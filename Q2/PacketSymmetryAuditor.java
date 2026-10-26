public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        String packet = "ABBA";

        TransactionStack stack = new TransactionStack();
        RequestQueue queue = new RequestQueue();
         for (int i = 0; i < packet.length(); i++) {
            stack.push(packet.charAt(i));
            queue.enqueue(packet.charAt(i));
        }
    boolean palindrome = true;

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                palindrome = false;
                break;
            }
        }
