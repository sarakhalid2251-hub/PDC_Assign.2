public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        String packet = "ABBA";

        TransactionStack stack = new TransactionStack();
        RequestQueue queue = new RequestQueue();
        