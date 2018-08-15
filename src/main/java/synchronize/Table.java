package synchronize;

import java.util.ArrayList;
import java.util.Arrays;

class Table {

    ArrayList<Beer> beers = new ArrayList<>();
    boolean party = true;
    synchronized void addBeers(Beer[] beers) {
        if (this.beers.size() > 0) {
            throw new RuntimeException("Beers still on table!");
        }
        this.beers.addAll(Arrays.asList(beers));
        System.out.println("Added " + beers.length + "beers");
    }

    synchronized Beer getBeer() {
        if (beers.size() == 0) {
            System.out.println("NO BEERS!!!");
            notifyAll();

            return null;
        } else {
            Beer beer = this.beers.get(0);
            this.beers.remove(0);

            return beer;
        }

    }
}
