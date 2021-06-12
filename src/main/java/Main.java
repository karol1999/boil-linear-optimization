import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    static {
//        System.loadLibrary("jniortools");
//    }
    public static void main(String[] args) {
        List<Variable> variableList = new ArrayList<Variable>();
        List<Constraint> constraintList = new ArrayList<Constraint>();
        Function function = new Function(); //
        //List<Function> functionList = new ArrayList<Function>();

        double lowerBound; // variables
        double upperBound; // variables
        String name; // variables
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------------------------------------------------------- //

        // variables
        while(scanner.nextBoolean()){
            System.out.print("Wpisz dolne ograniczenie: ");
            lowerBound = scanner.nextDouble();
            System.out.print("Wpisz gorne ograniczenie: ");
            upperBound = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Wpisz nazwe wyrobu: ");
            name = scanner.nextLine();

            variableList.add(new Variable(lowerBound, upperBound, name)); // 0, 1, 2...

            System.out.println("Czy chcesz kontynuowac wprowadzanie danych (jednostkowe naklady wyrobow oraz nazwa)? ");
            //decision = scanner.nextBoolean();
        }
        //decision = true;

        double constraintValue;
        String nameOfConstraint;
        String relation;
        double rightSide;
        List<Double> constraintValuesList = new ArrayList<>(); // lista do przechowywania wartosci W1, W2 itd

        // -------------------------------------------------------------------------------------------- //

        // constraints
        while(scanner.nextBoolean()){
            // najpierw ograniczenia
            // nazwa ogarniczenia
            // relacja
            // prawa strona?

            // musimy wiedzieć ile W mamy, tutaj będzie przypisanie wartosci do W
            for(int i = 0; i<variableList.size(); i++){
                System.out.print("Wpisz wartosc ograniczenia: ");
                constraintValue = scanner.nextDouble(); // wspolczynnik przy kolejnych ogranicznikach
                constraintValuesList.add(constraintValue);
            }
            scanner.nextLine();

            System.out.print("Wpisz nazwe ograniczenia: ");
            nameOfConstraint = scanner.nextLine();
            //scanner.nextLine();
            System.out.print("Wpisz znak relacji: ");
            relation = scanner.nextLine();
            System.out.print("Wpisz gorne ograniczenie: ");
            rightSide = scanner.nextDouble();

            constraintList.add(new Constraint(relation, rightSide, nameOfConstraint, constraintValuesList));

            System.out.println("Czy chcesz kontynuowac wprowadzanie ograniczeń? ");
            //decision = scanner.nextBoolean();
        }
        //decision = true;

        List<Double> coefficientList = new ArrayList<>(); // zyski jednostkowe
        double coefficient;

        // -------------------------------------------------------------------------------------------- //

        // functions
        while(scanner.nextBoolean()){

            for(int i=0;i<variableList.size();i++){
                System.out.print("Wpisz wartosc wspolczynnika: ");
                coefficient = scanner.nextDouble();
                coefficientList.add(coefficient);
            }

            // functionList.add(new Function(coefficientList));
            function.setCoefficientList(coefficientList);

            System.out.println("Czy chcesz kontynuowac wprowadzanie funkcji? ");
            //decision = scanner.nextBoolean();
        }

        // -------------------------------------------------------------------------------------------- //

        // solver

        Solver solver = new Solver(constraintList, function, variableList);
        solver.max();
        solver.variableToString();
        solver.functionToString();
    }
}
