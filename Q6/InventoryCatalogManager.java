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