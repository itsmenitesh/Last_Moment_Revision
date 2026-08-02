package java8;
/*
anonymous inner class means when we have more than one abstract method in our interface and we don't want
to implement it by creating class if we want to directly access it, so we can do via main method by using
anonymous inner class were we create object of interface, and we put curly bracket and inside of that we
 override the abstract method you can see below.
*/
interface A{
    String SayHello();
    int SayNumber();

}
public class Anonymous_inner_class {
    public static void main(String[] args) {
        A a = new A() {
            @Override
            public String SayHello() {
                return "Nitesh";
            }

            @Override
            public int SayNumber() {
                return 7478;
            }
        };
        System.out.println(a.SayHello()+" "+a.SayNumber());

    }
}
