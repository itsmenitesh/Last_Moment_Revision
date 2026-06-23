package Java.Oops.Interface;


interface Payement{    
    void pay();
    void payementDetails();

}
class CreditCard implements Payement{
    public void pay(){
        System.out.println("Paying with Credit Card");
    }
    public void payementDetails(){
        System.out.println("Credit Card Number: 1234-5678-9012-3456");
    }
}
public class Interface {
    public static void main(String[] args) {
       Payement payment = new CreditCard();
       payment.pay();
        payment.payementDetails();
    }
}
