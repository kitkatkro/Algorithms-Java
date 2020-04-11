package dataStructure;

import java.util.EmptyStackException;

public class Stack<Item> {
    private Item[] list;
    private int indexTop = -1;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public Stack() {
        list = (Item[])(new Object[DEFAULT_CAPACITY]);
    }

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Incorrect size");
        } else {
            list = (Item[])(new Object[capacity]);
        }
    }

    public void push (Item element) {
        if (isFull()) {
            throw new StackOverflowError();
        } else {
            list[++indexTop] = element;
            size++;
        }
    }

    public Item peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return list[indexTop];
        }
    }

    public Item pop() {
        Item temp = peek();
        list[indexTop] = null;
        indexTop--;
        size--;
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

}
