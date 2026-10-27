import java.util.concurrent.ForkJoinPool;
public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        double[] assets = new double[10000];

        for (int i = 0; i < assets.length; i++) {
            assets[i] = i + 100;
        }

        ForkJoinPool pool = new ForkJoinPool();

        long startTime = System.nanoTime();

        double totalRisk = pool.invoke(
            new ParallelRiskCalculator(assets, 0, assets.length)
        );
        pool.invoke(
            new PortfolioThresholdTask(assets, 0, assets.length, 5000)
        );

        long endTime = System.nanoTime();

        System.out.println("Total Risk: " + totalRisk);
        System.out.println("Adjusted first asset: " + assets[0]);
        System.out.println("Execution time: "
                + (endTime - startTime) / 1_000_000.0 + " ms");
        pool.shutdown();
    }
}