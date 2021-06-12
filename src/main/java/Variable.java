public class Variable {
    private double upperBound;
    private double lowerBound;
    private String name;

    Variable(){}

    Variable(double upperBound, double lowerBound, String name){
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.name = name;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
