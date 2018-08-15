package threads;

public class Main {
    public static void main(String... args) throws InterruptedException {

        Thread t1 = new Thread(new RunnableExample());
        Thread t2 = new ThreadExample();
        Thread t3 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread 3 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 3 end");
            }
        };
        Thread t4 = new Thread(() -> {
            System.out.println("thread 4 start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 4 end");
        });

        t1.start();
        System.out.println(t1.getName() + " " + t1.getPriority());
        t1.join();
        t2.start();
        System.out.println(t2.getName() + " " + t2.getPriority());
        t3.start();
        System.out.println(t3.getName() + " " + t3.getPriority());
        t4.start();
        System.out.println(t4.getName() + " " + t4.getPriority());


        for (int i=0; i<10; i++) {
            Thread x = new Thread(() -> {
                System.out.println("thread x start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread x end");
            });
            x.start();

            System.out.println("Start x " + x.getId() + " " + x.getName() + " " + x.getPriority());
        }


    }
}
