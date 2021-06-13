import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    // number of variables, constraints
    int variableNumber, constraintNumber;

    // zmienna, która będzie przechowywać znak (równość, mniejszość itd)
    // TODO: jakieś funkcjonalności w przyszłości dodać bo jak nie to wytarczy zwykłą zmienną zadeklarować nie klase
    // Constraint constraint;

    MPSolver solver = MPSolver.createSolver("GLOP"); // declare the solver (GLOP in the backend)
    // MPSolver is a wrapper for the OR-Tools linear solver, GLOP, as well as several mixed integer programming solvers

    // create the variables
    public List<MPVariable> variablesList = new ArrayList<>();

    // define constraints
    public List<MPConstraint> constraintsList = new ArrayList<>();

    // define the objective function (objective function -> funkcja celu)
    MPObjective objectiveFunction = solver.objective();

    Solver(){}

    // constraintsRelationSignList -> constraintList
    // set constrains and set coefficients in objective function
    public Solver(List<Constraint> constraintsRelationSignList, Function function,
                  List<Variable> variableList) {

        variableNumber = variableList.size();
        constraintNumber = constraintsRelationSignList.size();

        // x1 = (0, 3000, W1), x2 = (0, 4000, W2)
        for(Variable var : variableList){
            this.variablesList.add(solver.makeNumVar(var.getLowerBound(),var.getUpperBound(),var.getName()));
        }

//        for(MPVariable variable : variablesList){
//            this.variablesList.add(solver.makeNumVar(variable.lb(),variable.ub(),variable.name()));
//        }

        int j=0;
        // mamy trzy elementy klasy Constraint,
        for(Constraint constraint1 : constraintsRelationSignList){
            int i=0;
            if(constraint1.getRelationSign().equals("=")){
                this.constraintsList.add(solver.makeConstraint(constraint1.getUpperBound(),constraint1.getUpperBound(),constraint1.getName()));
            }else if(constraint1.getRelationSign().equals(">=")){
                this.constraintsList.add(solver.makeConstraint(constraint1.getUpperBound(),constraint1.getLowerBound(),constraint1.getName()));
            }else{
                this.constraintsList.add(solver.makeConstraint(constraint1.getLowerBound(),constraint1.getUpperBound(),constraint1.getName()));
            }

            //
            for(double d : constraint1.getParameters()){
                this.constraintsList.get(j).setCoefficient(this.variablesList.get(i), d);
                i++;
            }
            j++;
        }

        int i=0;
        for(MPVariable v : this.variablesList){
            this.objectiveFunction.setCoefficient(v, function.getCoefficientList().get(i));
            i++;
        }
    }

    public void max(){
        objectiveFunction.setMaximization();
        solver.solve();
    }

    public void min(){
        objectiveFunction.setMinimization();
        solver.solve();
    }

    public String variableToString(){
        String tempStringVariable = "";
        for(MPVariable var : variablesList){
            tempStringVariable = tempStringVariable + var.name() + " = " + var.solutionValue() + "\n";
        }
        return tempStringVariable;
    }

    public String functionToString(){
        String temp = "Wartosc funkcji: ";
        temp = temp + objectiveFunction.value();
        return temp;
    }
}
