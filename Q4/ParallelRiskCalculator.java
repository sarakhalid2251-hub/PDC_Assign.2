import java.util.concurrent.RecursiveTask;

class ParallelRiskCalculator extends RecursiveTask<Double> {
    private double[] data;
    private int start;
    private int end;
    private static final int THRESHOLD = 1000;

    public ParallelRiskCalculator(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }
    