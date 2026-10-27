public class SensorGridMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        double[] data = new double[50000];

        for (int i = 0; i < data.length; i++) {
            data[i] = (i * 7) % 1000;
        }

        data[123] = -10;
        data[456] = 2000;

        double[] min = {Double.MAX_VALUE, Double.MAX_VALUE};
        double[] max = {Double.MIN_VALUE, Double.MIN_VALUE};

        long start = System.nanoTime();
        Thread t1 = new Thread(() -> {
    min[0] = new ParallelMinSearch(data, 0, 25000).processGrid();
});
        Thread t2 = new Thread(() -> {
    min[1] = new ParallelMinSearch(data, 25000, 50000).processGrid();
});

Thread t3 = new Thread(() -> {
    max[0] = new ParallelMaxSearch(data, 0, 25000).processGrid();
});

Thread t4 = new Thread(() -> {
    max[1] = new ParallelMaxSearch(data, 25000, 50000).processGrid();
});
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long end = System.nanoTime();

        System.out.println("Minimum: " + Math.min(min[0], min[1]));
        System.out.println("Maximum: " + Math.max(max[0], max[1]));
        System.out.println("Execution Time: "
                + (end - start) / 1_000_000.0 + " ms");
    }
}