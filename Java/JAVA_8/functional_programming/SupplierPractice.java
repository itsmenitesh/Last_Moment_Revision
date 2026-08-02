package java8.functional_programming;

import java.util.function.Supplier;

public class SupplierPractice {
    public static void main(String[] args) {
        //first example
        Supplier<Integer>supplier = ()-> 1;
        System.out.println(supplier.get());
    }
}
