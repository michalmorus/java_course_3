package synchronize;

public class Consumer implements Runnable {

    private Table table;
    private double capacity;

    Consumer(Table table, double capacity) {
        this.table = table;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        System.out.println("run");
        while (this.table.party || this.capacity > 0) {
            System.out.println("get beer");
            Beer beer = this.table.getBeer();
            if (beer != null) {
                try {
                    System.out.println("drinking...");
                    Thread.sleep((int)beer.getSize());
                    System.out.println("after beer");
                    this.capacity -= beer.getSize();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("waiting for beer");
            }
        }
    }
}
