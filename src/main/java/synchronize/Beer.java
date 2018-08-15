package synchronize;

public class Beer {

    private int size;

    Beer(int size) {
        this.size = size;
    }

    Beer(String size) {
        if (size.equals("small")) {
            this.size = 100;
        } else if (size.equals("medium")) {
            this.size = 250;
        } else if (size.equals("large")) {
            this.size = 500;
        } else {
            throw new RuntimeException("yOU ARE TO much drunk! go home");
        }
    }

    double getSize() {
        return this.size;
    }
}
