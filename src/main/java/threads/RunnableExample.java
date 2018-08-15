package threads;

public class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("tread 1 start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread 1 end!");
    }
}
