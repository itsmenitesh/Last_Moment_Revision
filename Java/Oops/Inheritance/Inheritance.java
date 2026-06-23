
class Employee{
    private int workingDaysInMonth;
    int leave;

    void post(){
        System.out.println("I am an Employee");
    }
    void setWorkingDaysInMonth(){
        System.out.println(workingDaysInMonth);
    }
void salary(){
    System.out.println("I am getting 70000 per month");
}
    Employee(int workingDaysInMonth, int leave){
        this.workingDaysInMonth = workingDaysInMonth;
        this.leave = leave;
        System.out.println("I am an Employee Constructor");

    }

}
class Manager extends Employee{
    // int workingDaysInMonth= 20;
    // int leave = 5;
    void post(){
        System.out.println("I am a Manager");
    }
    void salary(){
        System.out.println("I am getting 150000 per month");
    }
    Manager(int workingDaysInMonth, int leave){
        super(workingDaysInMonth, leave);
        System.out.println("I am a Manager Constructor");

    }

}


class Inheritance {
    public static void main(String[] args) {
        Manager m1 = new Manager(10, 7);
        m1.post();
        m1.salary();
        m1.setWorkingDaysInMonth();
        System.out.println(m1.leave);
    }
}