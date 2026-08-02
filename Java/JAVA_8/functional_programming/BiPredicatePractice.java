package java8.functional_programming;

import java.util.function.BiPredicate;

public class BiPredicatePractice {
    /*
    Its basically use for checking two arguments in predicate because in predicate we can put condition
    to check one argument for more than basically for two we can use BiPredicate
    */
    public static void main(String[] args) {
        //example 1
        BiPredicate<Integer,Integer> biPredicate = (x,y)-> x% 2==0 && y%2==0;
        System.out.println(biPredicate.test(3,6));
        //example 2
        BiPredicate<String , Integer> biPredicate1 = (x,y)->x.toLowerCase().charAt(0)=='n' && y==x.length();
        System.out.println(biPredicate1.test("NITESH",6));
        //example 3 AND
        BiPredicate<Integer,Integer>startWith=(x,y)->x%2==0 && y%2==0;
        BiPredicate<Integer,Integer>endWith=(x,y)->x%4==0 && y%4==0;
        BiPredicate<Integer,Integer>and = startWith.and(endWith);
        System.out.println(and.test(20,40));
        //example 4 nugget
        // Define a BiPredicate
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;

        // Negate the BiPredicate
        BiPredicate<Integer, Integer> isSumOdd = isSumEven.negate();

        // Test the original BiPredicate
        System.out.println("Is sum of 2 and 3 even? " + isSumEven.test(2, 3)); // Output: true

        // Test the negated BiPredicate
        System.out.println("Is sum of 2 and 3 odd? " + isSumOdd.test(2, 3)); // Output: false




    }
}
