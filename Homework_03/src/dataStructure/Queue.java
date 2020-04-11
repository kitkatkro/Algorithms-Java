package dataStructure;

import java.util.EmptyStackException;

public class Queue<Item> {
    private Item[] list;
    private int indexOfLastInsertElement = -1;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public Queue () {
        list = (Item[])(new Object[DEFAULT_CAPACITY]);
    }

    public Queue (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Incorrect size");
        } else {
            list = (Item[])(new Object[capacity]);
        }
    }

    public void insert(Item element) {
       if (isFull()) {
           throw new StackOverflowError();
       } else {
           list[++indexOfLastInsertElement] = element;
           size++;
       }
    }

    public Item peekFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return list[0];
        }
    }

    public Item remove() {
        Item temp = peekFront();
        for (int i=0; i < getSize()-1; i++) {
            list[i] = list[i+1];
        }
        list[indexOfLastInsertElement] = null;
        indexOfLastInsertElement--;
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
