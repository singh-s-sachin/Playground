package algorithm;

public class StackPen implements Cloneable {
    private final int size;
    private int[] stack;
    private int top;

    public StackPen() {
        this.size = 100;
        init();
    }

    private void init() {
        this.stack = new int[this.size];
        this.top = -1;
    }

    public StackPen(int size) {
        this.size = size;
        init();
    }

    public void insert(int data) throws Exception {
        if (top == size) {
            throw new Exception("Insert limit exceeded");
        }
        this.stack[++this.top] = data;
    }

    public int pop() throws Exception {
        if (this.top < 0) {
            throw new Exception("No data available");
        }
        int data = this.stack[this.top--];
        System.out.println(data + "\tTop:" + top);
        return data;
    }

    public void popAll() throws Exception {

        System.out.println("::::: Popping all from StackPen :::::");
        while (this.top >= 0) {
            this.pop();
        }
    }

    public boolean contains(int data) throws Exception {
        StackPen temp = (StackPen) this.clone();
        while (temp.top >= 0) {
            if (temp.pop() == data) {
                return true;
            }
        }
        return false;
    }

    public int min() throws Exception {
        int min = Integer.MAX_VALUE;
        StackPen temp = (StackPen) this.clone();
        while (temp.top >= 0) {
            int data = temp.pop();
            if (data < min) {
                min = data;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
