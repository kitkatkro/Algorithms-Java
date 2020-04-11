package dataStructure;

import java.util.EmptyStackException;

public class Deque<Item> {
    private Item[] list;
    private int nextLeft = 0;
    private int nextRight;
    private final int DEFAULT_CAPACITY = 10;
    private int size;

    public Deque () {
        list = (Item[])(new Object[DEFAULT_CAPACITY]);
        nextRight = DEFAULT_CAPACITY-1;
    }

    public Deque (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Incorrect size");
        } else {
            list = (Item[])(new Object[capacity]);
            nextRight = capacity-1;
        }
    }

    public void insertLeft (Item element) {
        if (isFull()) {
            throw new StackOverflowError();
        } else {
             if (nextLeft == 0) {
                 list[0] = element;
             } else {
                 shiftRight(0, nextLeft);
                 list[0] = element;
             }
             nextLeft++;
             size++;
        }
    }

    public void insertRight (Item element) {
        if (isFull()) {
            throw new StackOverflowError();
        } else {
            if (nextRight == list.length-1) {
                list[nextRight] = element;
            } else {
                shiftLeft(list.length-1,nextRight);
                list[list.length-1] = element;
            }
            nextRight--;
            size++;
        }
    }

    public Item peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Item temp;
            if (nextLeft == 0) {
                int tempIndex = 1;
                while (list[tempIndex] == null) {
                    tempIndex++;
                }
                temp = list[tempIndex];
            } else {
                temp = list[0];
            }
            return temp;
        }
    }

    public Item peekRight() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            Item temp;
            if (nextRight == list.length-1) {
                int tempIndex = list.length-2;
                while (list[tempIndex] == null) {
                    tempIndex--;
                }
                temp = list[tempIndex];
            } else {
                temp = list[list.length-1];
            }
            return temp;
        }
    }

    public Item removeLeft() {
        Item temp = peekLeft();
        shiftLeft(list.length-1, 0);
        size--;
        list[list.length-1] = null;
        nextRight = list.length-1;
        return temp;
    }

    public Item removeRight() {
        Item temp = peekRight();
        shiftRight(0, list.length-1);
        size--;
        list[0] = null;
        nextLeft = 0;
        return temp;
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return (getSize() == 0);
    }

    private boolean isFull() {
        return size == list.length;
    }

    private void shiftLeft(int begin, int end) {
        for (int i=end; i < begin; i++) {
            list[i] = list[i+1];
        }
    }

    private void shiftRight(int begin, int end) {
        for (int i=end; i > begin; i--) {
            list[i] = list[i-1];
        }
    }

    private void print() {
        for (int i=0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }



}
