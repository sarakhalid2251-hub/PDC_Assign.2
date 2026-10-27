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
