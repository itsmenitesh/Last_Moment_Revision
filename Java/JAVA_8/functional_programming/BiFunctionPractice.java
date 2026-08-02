package java8.functional_programming;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
    This is essentially used for operations involving two inputs and a single output.
    Just like a Function, which takes one argument and produces a result, BiFunction
    extends this to two arguments. It's useful when you need to perform a calculation,
    transformation, or any operation that requires two inputs to produce a single output.
*/

public class BiFunctionPractice {
    public static void main(String[] args) {
        //example 1
        BiFunction<String,String,Integer> biFunction=(x,y)->x.length()+y.length();
        System.out.println(biFunction.apply("nitesh","Choudhary"));
        //example 2
        BiFunction<String,String,String> biFunction1=(x,y)->x.substring(2,4)+y.substring(3,5);
        System.out.println(biFunction1.apply("Nitesh","Choudhary"));

        //example 3

        // Define a BiFunction to concatenate two strings
        BiFunction<String, String, String> concatenate = (str1, str2) -> str1 + str2;

        // Define a Function to convert a string to uppercase
        Function<String, String> toUpperCase = String::toUpperCase;

        // Compose the BiFunction and the Function
        BiFunction<String, String, String> concatenateAndToUpperCase = concatenate.andThen(toUpperCase);

        // Test the composed function
        String result = concatenateAndToUpperCase.apply("hello", "world");
        System.out.println(result); // Output: "HELLOWORLD"

    }
}
