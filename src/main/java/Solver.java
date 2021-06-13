import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    MPSolver solver = MPSolver.createSolver("GLOP");
    // declare the solver (GLOP in the backend)
    // MPSolver is a wrapper for the OR-Tools linear solver, GLOP, as well as several mixed integer programming solvers

    // create the variables
    public List<MPVariable> variablesList = new ArrayList<>();

    // define constraints
    public List<MPConstraint> constraintsList = new ArrayList<>();

    // define the objective function (funkcja celu)
    MPObjective objectiveFunction = solver.objective();

    Solver() {
    }

    // constraintsRelationSignList -> constraintList
    // set constrains and set coefficients in objective function
    public Solver(List<Constraint> constraintList, Function function,
                  List<Variable> variableList) {

        // x1 = (0, 3000, W1), x2 = (0, 4000, W2)
        // tworzymy zmienne opisujące wyroby: dolna granica, górna granica, nazwa
        for (Variable var : variableList) {
            this.variablesList.add(solver.makeNumVar(var.getLowerBound(), var.getUpperBound(), var.getName()));
        }

        int j = 0;
        // wprowadzanie ograniczeń zużycia surowców: solver.makeConstraint
        for (Constraint var : constraintList) {
            int i = 0;
            if (var.getRelationSign().equals("=")) {
                this.constraintsList.add(solver.makeConstraint(var.getUpperBound(), var.getUpperBound(), var.getName()));
            } else if (var.getRelationSign().equals(">=")) {
                this.constraintsList.add(solver.makeConstraint(var.getUpperBound(), var.getLowerBound(), var.getName()));
            } else {
                this.constraintsList.add(solver.makeConstraint(var.getLowerBound(), var.getUpperBound(), var.getName()));
            }

            // uzupełnienie współczynników przy wyrobach (zmiennych)(jednostkowe zużycie)
            for (double varDouble : var.getParameters()) {
                this.constraintsList.get(j).setCoefficient(this.variablesList.get(i), varDouble);
                i++;
            }
            j++;
        }

        int i = 0;
        // ustawienie współczynników do funkcji celu (jednostkowe zyski)
        for (MPVariable var : this.variablesList) {
            this.objectiveFunction.setCoefficient(var, function.getCoefficientList().get(i));
            i++;
        }
    }

    // maksymalizacja
    public void max() {
        objectiveFunction.setMaximization();
        solver.solve();
    }

    // minimalizacji
    public void min() {
        objectiveFunction.setMinimization();
        solver.solve();
    }

    // ile powinno zostać wyprodukowane poszczególne wyroby
    public String products() {
        String tempStringVariable = "";
        for (MPVariable var : variablesList) {
            tempStringVariable = tempStringVariable + var.name() + " = " + var.solutionValue() + "\n";
        }
        return tempStringVariable;
    }

    // zysk ze sprzedaży
    public String objectiveFunctionValue() {
        String tempVariable = "Wartosc funkcji: ";
        tempVariable = tempVariable + objectiveFunction.value();
        return tempVariable;
    }
}
