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