class TelemetryThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                getName() + " - CPU and Memory update " + i
            );
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                interrupt();
                return;
            }
        }
    }
}