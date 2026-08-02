package java8.functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatePractice {
    public static void main(String[] args) {
        //1st example
        Predicate<Integer> predicate = x-> x %2==0;
        System.out.println( predicate.test(8));

        //2nd example
        Predicate<String> predicate1 = x->x.toLowerCase().charAt(0)=='n';
        System.out.println(predicate1.test("Nitesh"));

        //3rd example AND
        Predicate<String> startWith = x->x.toLowerCase().charAt(0)=='n';
        Predicate<String> endWith = x->x.toLowerCase().charAt(x.length()-1)=='h';
//        System.out.println(startWith.test("Nitesh") && endWith.test("Nitesh")); //or another approach
        Predicate<String> and = startWith.and(endWith);
        System.out.println(and.test("Nitesh"));


        //4th example Nugget
        Predicate<String> nugget = x->x.toLowerCase().charAt(0)=='n';
        System.out.println(nugget.test("Nitesh"));


        //5th example when you have class
        Predicate<Student> student = x->x.id>1;
        List<Student> li = new ArrayList<>();

        li.add(new Student(1,"Nitesh"));

        li.add(new Student(2,"Jack"));
        li.add(new Student(3,"Denial"));
        for(Student st : li){
            System.out.println(student.test(st));
        }



    }
    public static class Student{
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
