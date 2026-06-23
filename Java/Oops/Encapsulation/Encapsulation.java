class BankAccount {
    private  int  Balance;
    private String UserFirstName;
    private String UserMiddleName;
    private String UserLastName;

    BankAccount(int amount, String FirstName, String MiddleName, String LastName){
        if(amount<=0) throw new IllegalArgumentException("Amount cannot be negative or zero");
        this.Balance = amount;

        if(FirstName.length()<=2) throw new IllegalArgumentException("First name must be at least 3 characters long");
        this.UserFirstName = FirstName;
        this.UserMiddleName = MiddleName;
        this.UserLastName = LastName;

    }

        BankAccount(int amount, String FirstName, String LastName){
       this(amount, FirstName, "", LastName);

    }
    public String withdraw(int amount){
        if(Balance>= amount){
            Balance-=amount;
        }
        else{
           return "You Do not have balance to withdraw, Avaialble Balance is "+ Balance;

        }
        return "Amount withdraw you current balance is "+ Balance;

    }
     public void Deposite(int amount){
        Balance+=amount;

     }

     public int  Balance (){
        return Balance;
     }



}

class Encapsulation{
        public static void main(String[] args) {
        BankAccount User4 = new BankAccount(20000, "Bhalar", "pora","devan");    
        BankAccount User3 = new BankAccount(4000, "Mahaendar", "Bahubali");
        BankAccount User2 = new BankAccount(3000, "La", "Puri");
        BankAccount User1 = new BankAccount(200, "Amrish", "Puri");

               System.out.println(User4);
                System.out.println(User3);
                System.out.println(User2);
                System.out.println(User1);



            
    }
}