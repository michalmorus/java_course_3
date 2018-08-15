package synchronize;

class Bar {

    private Consumer[] consumers;
    private Producer producer;

    Bar(Consumer[] consumers, Producer producer) {
        this.consumers = consumers;
        this.producer = producer;
    }

    void startParty() {
        Thread producerThread = new Thread(this.producer);
        producerThread.run();
        for (Consumer consumer : this.consumers) {
            System.out.println("asda");
            Thread thread = new Thread(consumer);
            thread.start();
        }
    }
}
