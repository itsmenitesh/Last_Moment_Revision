package java8.streamApi;

import java.util.*;
import java.util.stream.Collectors;

public class prime {
    public static void main(String[] args) {
                List<Integer> numbers = Arrays.asList(10,20,30,40,50,60,70,80,90,100 ,11,21,31,41,51,61,71,81,91,01);
            List<Integer> primeVal = numbers.stream().filter(i->isPrime(i)).collect(Collectors.toList());
            System.out.println(primeVal);



    }
    public static boolean isPrime(int i){
        if(i==1)return true;
        for(int  j=2;j<=i/2;j++){
            if(i%j==0)return false;
        }
        return true;
    }
}