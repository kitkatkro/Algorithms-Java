package dataStructure;

import java.util.EmptyStackException;

public class PriorityQueue<Item> {
    private int[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public PriorityQueue () {
        list = new int[DEFAULT_CAPACITY];
    }

    public PriorityQueue (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Incorrect size");
        } else {
            list = new int[capacity];
        }
    }

    public void insert(int element) {
        if (isFull()) {
            throw new StackOverflowError();
        } else {
            int i;
            if (size == 0)
                list[size++] = element;
            else {
                for (i = size - 1; i >= 0; i--) {
                    if (element > list[i])
                        list[i + 1] = list[i];
                    else
                        break;
                }
                list[i + 1] = element;
                size++;
            }
            print();
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return list[size - 1];
        }
    }

    public int remove() {
        int temp = peek();
        list[size-1] = 0;
        size--;
        print();
        return temp;
    }


    public int getSize() {
        return size;
    }

    private boolean isFull() {
        return size == list.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void print() {
        for (int i=0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
