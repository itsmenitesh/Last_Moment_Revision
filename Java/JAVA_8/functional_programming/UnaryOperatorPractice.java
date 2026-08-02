package java8.functional_programming;

import java.util.function.UnaryOperator;


/*
    UnaryOperator is a functional interface that represents an operation on a single
    operand that produces a result of the same type as its operand. It extends the
    Function interface, specializing it for cases where the input and output types are
    the same. This is useful when you need to perform an operation or transformation on
    a value of a certain type and produce a result of the same type.
*/

public class UnaryOperatorPractice {
    public static void main(String[] args) {
        //example 1
        UnaryOperator<Integer> unaryOperator = x->x+100;
        System.out.println(unaryOperator.apply(50));
        //example 2
        UnaryOperator<String> unaryOperator1=x->x.substring(2,5);
        System.out.println(unaryOperator1.apply("Nitesh"));

        //example 3
        // Define a UnaryOperator using the identity method
        UnaryOperator<Integer> identityOperator = UnaryOperator.identity();

        // Test the identity operator
        int result = identityOperator.apply(10);
        System.out.println("Result: " + result); // Output: 10

    }
}
