import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    // number of variables, constraints
    int variableNumber;

    MPSolver solver = MPSolver.createSolver("GLOP"); // declare the solver (GLOP in the backend)
    // MPSolver is a wrapper for the OR-Tools linear solver, GLOP, as well as several mixed integer programming solvers

    // create the variables
    List<MPVariable> variablesList = new ArrayList<>();

    // define constraints
    List<MPConstraint> constraintsList = new ArrayList<>();

    // define the objective function (objective function -> funkcja celu)
    MPObjective objectiveFunction = solver.objective();

    // set constrains and set coefficients in objective function
    public Solver(List<MPVariable> variablesList, List<MPConstraint> constraintsList, MPObjective objectiveFunction) {

        variableNumber = variablesList.size();

        for(MPVariable variable : variablesList){
            this.variablesList.add(solver.makeNumVar(variable.lb(),variable.ub(),variable.name()));
        }

        for(MPConstraint constraint : constraintsList){
            //if(constraint.)
        }

    }
}
