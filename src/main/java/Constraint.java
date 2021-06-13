import java.util.List;

public class Constraint {

    private String relationSign;
    private double upperBound;
    private String name;
    private List<Double> parameters;

    Constraint() {
    }

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
