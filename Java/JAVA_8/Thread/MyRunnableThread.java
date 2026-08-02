package java8.Thread;

public class MyRunnableThread {
    public static void main(String[] args) {
//        MyRunnableThread myThread = new MyRunnableThread();


        Runnable runnable =() ->{
            for(int i=0;i<=5;i++){
                System.out.println(i);
            }
        };
        Thread thread= new Thread(runnable);
        thread.start();
    }


}
