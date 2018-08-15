package synchronize;

public class Main {

    public static void main(String... args) {

        Table table = new Table();
        Consumer[] consumers = {
                new Consumer(table, 2500),
                new Consumer(table,1000),
                new Consumer(table,4000)
        };
        Producer producer = new Producer(table);

        Bar bar = new Bar(consumers, producer);
        bar.startParty();
    }
}
