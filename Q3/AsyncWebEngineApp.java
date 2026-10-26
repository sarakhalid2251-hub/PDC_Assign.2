public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("Main thread: "
                + Thread.currentThread().getName());

        TelemetryThread t1 = new TelemetryThread();
        t1.setName("Telemetry-Worker");

        Thread t2 = new Thread(new LogProcessorTask());
        t2.setName("Log-Worker");

        t1.start();
        t2.start();

        System.out.println("Both threads started");
    }
}
