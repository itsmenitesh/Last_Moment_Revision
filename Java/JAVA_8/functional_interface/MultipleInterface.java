package java8.functional_interface;

interface ParentClass{
    default void HelloMethod(){
        System.out.println("Hello i am parent class");
    }
}
interface ChildClass{
    default void HelloMethod(){
        System.out.println("Hello i am Child class");
    }
}
public class MultipleInterface implements ParentClass,ChildClass{
    public static void main(String[] args) {
        MultipleInterface ml = new MultipleInterface();
        ml.HelloMethod();

    }

    @Override
    public void HelloMethod() {
        ParentClass.super.HelloMethod();
    }
}
