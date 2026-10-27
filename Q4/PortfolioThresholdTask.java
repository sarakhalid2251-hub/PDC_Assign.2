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