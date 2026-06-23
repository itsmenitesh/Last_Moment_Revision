package Java.Oops.Interface;

interface CodeReview{
    void review();
    void salary();
    default void workingHour(){
        System.out.println("I am working for 8 hours");
    }
}
interface CodeQuality{
    void quality();
    void salary();
    default void workingHour(){
        System.out.println("I am working for 6 hours");
    }
}

class Developer implements CodeReview, CodeQuality{
    public void review(){
        System.out.println("Code Review is done");
    }
    public void quality(){
        System.out.println("Code Quality is good");
    }
    public void salary(){
        System.out.println("I am getting 100000 per month");
    }
    public void workingHour(){
        CodeReview.super.workingHour();
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Developer dev = new Developer();
        dev.review();
        dev.quality();
        dev.salary();
    }
}
