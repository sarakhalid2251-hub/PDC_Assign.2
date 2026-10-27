public class ParallelMaxSearch {

    double[] data;
    int start;
    int end;

    public ParallelMaxSearch(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public double processGrid() {

        double max = -Double.MAX_VALUE;

        for (int i = start; i < end; i++) {

            if (data[i] > max) {
                max = data[i];
            }
        }

        return max;
    }
}
