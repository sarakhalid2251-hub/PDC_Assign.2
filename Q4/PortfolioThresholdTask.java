import java.util.concurrent.RecursiveAction;

class PortfolioThresholdTask extends RecursiveAction {
    private double[] data;
    private int start;
    private int end;
    private double riskCap;
    private static final int THRESHOLD = 1000;

    public PortfolioThresholdTask(double[] data, int start,
                                  int end, double riskCap) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.riskCap = riskCap;
    }
    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                if (data[i] > riskCap) {
                    data[i] = data[i] * 0.95;
                }
            }
        } else {
            int mid = (start + end) / 2;

            invokeAll(
                new PortfolioThresholdTask(data, start, mid, riskCap),
                new PortfolioThresholdTask(data, mid, end, riskCap)
            );
        }
    }
}