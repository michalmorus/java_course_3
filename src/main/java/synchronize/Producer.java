package synchronize;

import java.util.Random;

class Producer implements Runnable {

    private Table table;

    Producer(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (this.table.party) {
            if (this.table.beers.isEmpty()) {
                this.table.addBeers(getBeers());
            }
        }
    }

    private Beer[] getBeers() {
        Random random = new Random();
        int count = random.nextInt(10);
        Beer[] beers = new Beer[count];
        for (int i = 0; i < count; i++) {
            beers[i] = new Beer(250);
        }

        return beers;
    }
}
