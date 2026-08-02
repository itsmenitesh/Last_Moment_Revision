package java8.functional_interface;

@FunctionalInterface
 interface parent {
    public void SayHello();

    default void SayBy() {

    }

}

@FunctionalInterface
interface child extends parent{
    public void SayHello();
    default void SayBy(){

    }
}
public interface MyFunctionalInterface{
    public static void main(String[] args) {

    }
}