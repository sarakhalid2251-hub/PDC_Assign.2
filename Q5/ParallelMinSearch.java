
public class ParallelMinSearch {

    double[] data;
    int start;
    int end;

    public ParallelMinSearch(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public double processGrid() {

        double min = Double.MAX_VALUE;

        for (int i = start; i < end; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }

        return min;
    }
}
