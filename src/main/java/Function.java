import java.util.List;

public class Function {

    Function() {
    }

    private List<Double> coefficientList;

    Function(List<Double> coefficientList) {
        this.coefficientList = coefficientList;
    }

    public List<Double> getCoefficientList() {
        return coefficientList;
    }

    public void setCoefficientList(List<Double> coefficientList) {
        this.coefficientList = coefficientList;
    }

}
