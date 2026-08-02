package java8.functional_interface;

@FunctionalInterface
interface User{
    String MyName();



}



//class Data implements User{
//    @Override
//    public String MyName() {
//        return "Nitesh";
//    }
//}
public class Functional_interface_actual_implementation {
    public static void main(String[] args) {
//        Data val = new Data();
//        val.MyName();
        User val =()->"Nitesh";
        System.out.println(val.MyName());
    }
}
