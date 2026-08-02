package java8;

import java.util.*;

class Student{
    int id;
    String name;
    String gender;
    int age;
    Student(int id, String name,String gender,int age){
        this.id=id;
        this.name=name;
        this.gender=gender;
        this.age=age;
    }
    public String toString(){
        return "id : "+id+" name : "+name+" gender : "+gender+" age :"+age;
    }
}

public class Comparator_with_lambda {
    public static void main(String[] args) {

        List<Student> li = new ArrayList<>();
        li.add(new Student(1,"nitesh","Male",26));
        li.add(new Student(2,"debanjana","FeMale",26));
        li.add(new Student(3,"Jack","Male",25));
        li.add(new Student(4,"jock ","FeMale",28));
        Collections.sort(li,(a,b)->b.age- a.age);
        for (Student student : li) {
            System.out.println("ID: " + student.id + ", Name: " + student.name + ", Gender: " + student.gender + ", Age: " + student.age);
        }


        //        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(8);
//        list.add(5);
//        list.add(9);
//        list.add(2);
//        list.add(0);
//        Collections.sort(list,(a,b)->b-a);
//        System.out.println(list);
//////////////////////////////////////////
//        Map<Integer , Integer> hm = new TreeMap<>((a,b)->b-a);
//        hm.put(1,4);
//        hm.put(3,4);
//        System.out.println(hm);
    }
}
