public class CacheLocalityBenchmark {
    static final int N = 2000;
    static double[][] matrix = new double[N][N];

    static double traverseRowMajor() {
        double sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
     static double traverseColumnMajor() {
        double sum = 0;

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = i + j;
            }
        }
        double rowTime = 0;
        double columnTime = 0;
        for (int i = 1; i <= 10; i++) {
            long start = System.nanoTime();
            traverseRowMajor();
            rowTime += System.nanoTime() - start;

            start = System.nanoTime();
            traverseColumnMajor();
            columnTime += System.nanoTime() - start;
        }
        rowTime /= 10;
        columnTime /= 10;
        System.out.println("Average Row-Major: "
                + rowTime / 1_000_000.0 + " ms");

        System.out.println("Average Column-Major: "
                + columnTime / 1_000_000.0 + " ms");

        System.out.println("Speedup Ratio (Column / Row): "
                + columnTime / rowTime);
    }
}