package threads;

public class ThreadExample extends Thread {

    public void run() {
        System.out.println("thread 2 start!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread 2 end!");
    }
}
