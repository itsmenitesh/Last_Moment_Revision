package java8.functional_programming;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/*
    BinaryOperator is like a math function where you give it two numbers of the same type,
     and it gives you back another number of the same type.
    It's handy for simple math operations like addition,
     subtraction, multiplication, or even more complex operations where you need two inputs
     and produce one output.
*/

public class BinaryOperatorPractice {
    public static void main(String[] args) {
        //example 1
        BinaryOperator<String>binaryOperator=(x,y)->x+y;
        System.out.println(binaryOperator.apply("Nitesh","Choudhary"));

        //example 2 minBy
        // Define a Comparator to compare strings by their lengths
        Comparator<String> lengthComparator = Comparator.comparing(String::length);

        // Use the minBy method to create a BinaryOperator that finds the minimum string by length
        BinaryOperator<String> minByLength = BinaryOperator.minBy(lengthComparator);

        // Test the BinaryOperator
        String shorterString = minByLength.apply("Nitesh", "Choudhary");
        System.out.println("Shorter string: " + shorterString);


        //example 4 MaxBy
        // Define a Comparator to compare strings by their lengths
        Comparator<String> lengthComparator1 = Comparator.comparing(String::length);

        // Use the maxBy method to create a BinaryOperator that finds the maximum string by length
        BinaryOperator<String> maxByLength = BinaryOperator.maxBy(lengthComparator);

        // Test the BinaryOperator
        String longerString = maxByLength.apply("Nitesh", "Choudhary");
        System.out.println("Longer string: " + longerString);
    }
}
