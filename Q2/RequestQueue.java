class RequestQueue {
    private char[] data = new char[100];
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public void enqueue(char c) {
        if (size < data.length) {
            rear = (rear + 1) % data.length;
            data[rear] = c;
            size++;
        }
    }
        public void enqueue(char c) {
        if (size < data.length) {
            rear = (rear + 1) % data.length;
            data[rear] = c;
            size++;
        }
    }
   public char dequeue() {
        char c = data[front];
        front = (front + 1) % data.length;
        size--;
        return c;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}