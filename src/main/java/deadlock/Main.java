package deadlock;

public class Main {

    private static class Resource {
        public int value;
    }

    private Resource resA = new Resource();
    private Resource resB = new Resource();

    public int read() {
        synchronized (resA) {
            synchronized (resB) {
                return resB.value + resA.value;
            }
        }
    }

    public void write(int a, int b) {
        synchronized (resB) {
            synchronized (resA) {
                resA.value = a;
                resB.value = b;
            }
        }
    }
}
