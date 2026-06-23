package Java.Oops.Abstraction;


abstract class Employee{

    private int workingDaysInMonth;
    int leave;
    Employee(int workingDaysInMonth, int leave){
        this.workingDaysInMonth = workingDaysInMonth;
        this.leave = leave;
        System.out.println("I am an Employee Constructor");

    }
    abstract void post();
    abstract void salary();

    void setWorkingDaysInMonthAndLeave(){
        System.out.println(workingDaysInMonth);
        System.out.println(leave);
    }
}

class Manager extends Employee{
    Manager(int workingDaysInMonth, int leave){
        super(workingDaysInMonth, leave);
        System.out.println("I am a Manager Constructor");

    }
    void post(){
        System.out.println("I am a Manager");
    }
    void salary(){
        System.out.println("I am getting 150000 per month");
    }

}
public class Abstraction {
    public static void main(String[] args) {
        Employee manager = new Manager(20, 5);
        manager.post();
        manager.salary();
    }
    
}
