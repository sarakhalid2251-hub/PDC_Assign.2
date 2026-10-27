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