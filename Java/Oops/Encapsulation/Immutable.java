final class AccountBalance{
    
    private final int balance ;
  

    public AccountBalance(int balance) {
        this.balance = balance;
    }
    public void getBalance(){
        System.out.println(balance);
    }
    
}

class Immutable{

    public static void main(String [] args){
        AccountBalance ab = new AccountBalance(20);
        AccountBalance ab2 = new AccountBalance(15);

        ab.getBalance();
        ab2.getBalance();
    }
}