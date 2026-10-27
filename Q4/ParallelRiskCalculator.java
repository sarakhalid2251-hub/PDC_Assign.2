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
   @Override
    protected Double compute() {
        if (end - start <= THRESHOLD) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
            return sum;
        }
         int mid = (start + end) / 2;
        ParallelRiskCalculator left =
                new ParallelRiskCalculator(data, start, mid);
        ParallelRiskCalculator right =
                new ParallelRiskCalculator(data, mid, end);
        left.fork();
        double rightResult = right.compute();
        double leftResult = left.join();
        return leftResult + rightResult;
    }
}
