import java.util.*;
import java.util.concurrent.*;

public class InventoryCatalogManager {
    static final int THREADS = 10;
    static final int OPERATIONS = 50000;

    public static void benchmarkSynchronizedMap()
            throws InterruptedException {
        Map<String, Integer> map =
            Collections.synchronizedMap(new HashMap<>());

        benchmark(map, "SynchronizedMap");
    }
    public static void benchmarkConcurrentMap()
            throws InterruptedException {
        Map<String, Integer> map = new ConcurrentHashMap<>();

        benchmark(map, "ConcurrentHashMap");
    }

    public static void benchmark(Map<String, Integer> map, String name)
            throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            map.put("P" + i, 100);
        }
        ExecutorService pool = Executors.newFixedThreadPool(THREADS);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(THREADS);

        long startTime = System.nanoTime();

        for (int t = 0; t < THREADS; t++) {
            pool.execute(() -> {
                try {
                    start.await();

                    for (int i = 0; i < OPERATIONS; i++) {
                        String id = "P" + (i % 100);

                        synchronized (map) {
                            int stock = map.get(id);
                            map.put(id, stock + 1);
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                }
            });
        }
        start.countDown();
        done.await();

        long endTime = System.nanoTime();
        pool.shutdown();

        double seconds = (endTime - startTime) / 1_000_000_000.0;
        int totalOperations = THREADS * OPERATIONS;

        System.out.println(name);
        System.out.println("Execution Time: "
                + (seconds * 1000) + " ms");
        System.out.println("Throughput: "
                + (totalOperations / seconds) + " operations/second");
    }
    public static void main(String[] args) throws InterruptedException {
        benchmarkSynchronizedMap();
        benchmarkConcurrentMap();
    }
}


