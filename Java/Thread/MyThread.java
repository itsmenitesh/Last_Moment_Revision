package Thread;

public class MyThread implements Runnable{
    public void run(){
        //Task
        for(int i=1;i<=10;i++){
            System.out.println("The value of i = "+i);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        Thread thread = new Thread(t);

        MySecondThread second = new MySecondThread();
        second.start();
        thread.start();

    }
}
