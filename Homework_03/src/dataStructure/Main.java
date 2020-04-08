package dataStructure;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println("Stack: " + stack.peek() + ", size: " + stack.getSize());


        Queue<Integer> queue = new Queue<>(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.remove();
        queue.remove();
        System.out.println("Queue: " + queue.peekFront() + ", size: " + queue.getSize());

        Deque<Integer> deque = new Deque<>(5);
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertRight(11);
        deque.insertRight(22);
        deque.insertRight(33);
        deque.removeRight();
        deque.removeRight();
        deque.insertRight(44);
        deque.insertLeft(3);
        System.out.println("Deque: Left: " + deque.peekLeft() + ", Right: " + deque.peekRight() + ", size: " + deque.getSize());

        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(1);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.remove();
        priorityQueue.remove();
        System.out.println("Priority queue: " + priorityQueue.peek() + ", size: " + priorityQueue.getSize());
    }
}
