class TransactionStack {
    private char[] data = new char[100];
    private int top = -1;

    public void push(char c) {
        if (top < data.length - 1) {
            data[++top] = c;
        }
    }

    public char pop() {
        return data[top--];
    }

    public char peek() {
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
