// =, <=, >=

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Constraint {

    private String relationSign;
    private double upperBound; // right side
    private String name;
    private List<Double> parameters;

    Constraint() {}

    Constraint(String relationSign, double upperBound, String name, List<Double> parameters) {
        this.relationSign = relationSign;
        this.upperBound = upperBound;
        this.name = name;
        this.parameters = parameters;
    }

    public String getRelationSign() {
        return relationSign;
    }

    public void setRelationSign(String relationSign) {
        this.relationSign = relationSign;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public double getLowerBound() {
        return 0.0;
    }

    public String getName() {
        return name;
    }

    public List<Double> getParameters() {
        return parameters;
    }

    public void setParameters(List<Double> parameters) {
        this.parameters = parameters;
    }
}
