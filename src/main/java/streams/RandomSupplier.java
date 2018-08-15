package streams;

import java.util.Random;
import java.util.function.Supplier;

public class RandomSupplier implements Supplier<Integer> {

    private Random random;
    private int max;

    public RandomSupplier(int max) {
        this.max = max;
        this.random = new Random();
    }

    @Override
    public Integer get() {
        return this.random.nextInt(max);
    }
}
