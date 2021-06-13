public class Variable {
    private double upperBound;
    private double lowerBound;
    private String name;

    Variable() {
    }

    Variable(double upperBound, double lowerBound, String name) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.name = name;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public String getName() {
        return name;
    }
}
