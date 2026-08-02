package java8.functional_interface;

interface A{

    void name();
    default void SayBy(){
        System.out.print("Hello i am ParentClass");
    }


}
class B implements A {
    @Override
    public void name() {
        System.out.println("Hello bhailog");
    }

}


public class DefaultMethod {
    public static void main(String[] args) {

        A object = new B();
        object.SayBy();
    }

}
