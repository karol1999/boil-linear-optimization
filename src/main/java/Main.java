import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    static {
//        System.loadLibrary("jniortools");
//    }
    public static void main(String[] args) {
        Loader.loadNativeLibraries();
        List<Variable> variableList = new ArrayList<Variable>();
        List<Constraint> constraintList = new ArrayList<Constraint>();
        Function function = new Function(); //

//        double lowerBound; // variables
//        double upperBound; // variables
//        String name; // variables
//        Scanner scanner = new Scanner(System.in);
//
//        // -------------------------------------------------------------------------------------------- //
//
//        // variables
//        while(scanner.nextBoolean()){
//            System.out.print("Wpisz dolne ograniczenie: ");
//            lowerBound = scanner.nextDouble();
//            System.out.print("Wpisz gorne ograniczenie: ");
//            upperBound = scanner.nextDouble();
//            scanner.nextLine();
//            System.out.print("Wpisz nazwe wyrobu: ");
//            name = scanner.nextLine();
//
//            variableList.add(new Variable(lowerBound, upperBound, name)); // 0, 1, 2...
//
//            System.out.println("Czy chcesz kontynuowac wprowadzanie danych (jednostkowe naklady wyrobow oraz nazwa)? ");
//            //decision = scanner.nextBoolean();
//        }
//        //decision = true;
//
//        double constraintValue;
//        String nameOfConstraint;
//        String relation;
//        double rightSide;
//        List<Double> constraintValuesList = new ArrayList<>(); // lista do przechowywania wartosci W1, W2 itd
//
//        // -------------------------------------------------------------------------------------------- //
//
//        // constraints
//        while(scanner.nextBoolean()){
//            // najpierw ograniczenia
//            // nazwa ogarniczenia
//            // relacja
//            // prawa strona?
//
//            // musimy wiedzieć ile W mamy, tutaj będzie przypisanie wartosci do W
//            for(int i = 0; i<variableList.size(); i++){
//                System.out.print("Wpisz wartosc ograniczenia: ");
//                constraintValue = scanner.nextDouble(); // wspolczynnik przy kolejnych ogranicznikach
//                constraintValuesList.add(constraintValue);
//            }
//            scanner.nextLine();
//
//            System.out.print("Wpisz nazwe ograniczenia: ");
//            nameOfConstraint = scanner.nextLine();
//            //scanner.nextLine();
//            System.out.print("Wpisz znak relacji: ");
//            relation = scanner.nextLine();
//            System.out.print("Wpisz gorne ograniczenie: ");
//            rightSide = scanner.nextDouble();
//
//            constraintList.add(new Constraint(relation, rightSide, nameOfConstraint, constraintValuesList));
//
//            System.out.println("Czy chcesz kontynuowac wprowadzanie ograniczeń? ");
//            //decision = scanner.nextBoolean();
//        }
//        //decision = true;
//
//        List<Double> coefficientList = new ArrayList<>(); // zyski jednostkowe
//        double coefficient;
//
//        // -------------------------------------------------------------------------------------------- //
//
//        // functions
//        while(scanner.nextBoolean()){
//
//            for(int i=0;i<variableList.size();i++){
//                System.out.print("Wpisz wartosc wspolczynnika: ");
//                coefficient = scanner.nextDouble();
//                coefficientList.add(coefficient);
//            }
//
//            // functionList.add(new Function(coefficientList));
//            function.setCoefficientList(coefficientList);
//
//            System.out.println("Czy chcesz kontynuowac wprowadzanie funkcji? ");
//            //decision = scanner.nextBoolean();
//        }

        // -------------------------------------------------------------------------------------------- //

        // solver

        double lowerBound1 = 0.0;
        double upperBound1 = 3000.0;
        String name1 = "W1";

        double lowerBound2 = 0.0;
        double upperBound2 = 4000.0;
        String name2 = "W2";

        variableList.add(new Variable(upperBound1, lowerBound1, name1));
        variableList.add(new Variable(upperBound2, lowerBound2, name2));

        // ------------------------------------------------------------ //

        double constraintValue1 = 16.0;
        double constraintValue2 = 24.0;
        String nameOfConstraint1 = "Pret";
        String relation1 = "<=";
        double rightSide1 = 960000.0;
        List<Double> constraintValuesList1 = new ArrayList<>();
        constraintValuesList1.add(constraintValue1);
        constraintValuesList1.add(constraintValue2);

        double constraintValue3 = 16.0;
        double constraintValue4 = 10.0;
        String nameOfConstraint2 = "Tasma";
        String relation2 = "<=";
        double rightSide2 = 80000.0;
        List<Double> constraintValuesList2 = new ArrayList<>();
        constraintValuesList2.add(constraintValue3);
        constraintValuesList2.add(constraintValue4);

        double constraintValue5 = 2.0;
        double constraintValue6 = -3.0;
        String nameOfConstraint3 = "Stosunek";
        String relation3 = "=";
        double rightSide3 = 0.0;
        List<Double> constraintValuesList3 = new ArrayList<>();
        constraintValuesList3.add(constraintValue5);
        constraintValuesList3.add(constraintValue6);

        constraintList.add(new Constraint(relation1, rightSide1, nameOfConstraint1, constraintValuesList1));
        constraintList.add(new Constraint(relation2, rightSide2, nameOfConstraint2, constraintValuesList2));
        constraintList.add(new Constraint(relation3, rightSide3, nameOfConstraint3, constraintValuesList3));

        // ------------------------------------------------------------ //

        List<Double> coefficientList = new ArrayList<>();
        coefficientList.add(30.0);
        coefficientList.add(40.0);

        function.setCoefficientList(coefficientList);

        Solver solver = new Solver(constraintList, function, variableList);
        solver.max();
        System.out.println(solver.variableToString());
        System.out.println(solver.functionToString());
    }
}
