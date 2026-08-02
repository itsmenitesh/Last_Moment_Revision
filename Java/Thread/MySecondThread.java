package Thread;

public class MySecondThread extends Thread{
    public void run(){
        //Task
        for(int i=10;i>=1;i--){
            System.out.println("This it reverse value of i = "+i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}
