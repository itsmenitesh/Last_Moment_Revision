package java8.functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalPractice {
    public static void main(String[] args) {
        //first example
        Function<String , Integer> function= x-> x.length();
        System.out.println(function.apply("Nitesh"));
        System.out.println(function.apply("sikhghdggasddfsadfsdjkhf"));

        //second example
        Function<String , String> function1 = x->x.substring(2,4);
        System.out.println(function1.apply("Nitesh"));

        //third example


        Function<String, String> substring = x -> x.substring(0, 4);
        Function<List<Student>, List<Student>> st = li -> {
            List<Student> ans = new ArrayList<>();
            for (Student student : li) {
                if (substring.apply(student.getName()).equalsIgnoreCase("Nite")) {
                    ans.add(student);
                }
            }
            return ans;
        };

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Nitesh"));
        list.add(new Student(2, "Nikhil"));
        list.add(new Student(3, "nehal"));

        List<Student> sol = st.apply(list);

        System.out.println(sol);



        //fourth example andThen
        Function<Integer,Integer> first = x-> x+x;
        Function<Integer,Integer> second = x-> x*x*x;
        System.out.println(first.andThen(second).apply(2));
        System.out.println(second.andThen(first).apply(2));

        //fifth example compose
        Function<Integer,Integer> first1 = x-> x+x;
        Function<Integer,Integer> second2 = x-> x*x*x;
        Function<Integer,Integer> compose = first1.compose(second2);
        System.out.println(compose.apply(2));


        Function<String,String> identity=Function.identity();
        System.out.println(identity.apply("Nitesh"));
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

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
