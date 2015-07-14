/*
Basic Queue using a Linked List 
Based on Section 1.3 of Algorithms, 4th Edition
*/

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    
    //LinkedList that holds the Queue
    private LinkedList<T> queueList;
    
    //Constructor
    public Queue() {
        queueList = new LinkedList<T>();
    }
    
    //Adds item to front of queue
    public void enqueue(T toAdd) {
        queueList.addToFront(toAdd);
    }
    
    //Gets and removes item from end of queue
    public T dequeue() {
        return queueList.removeFromEnd();
    }

    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    //Iterator
    public Iterator<T> iterator() {
        return queueList.iterator();
    }

    public String toString() {
        String s = "";

        for (T i : queueList) {
            s += i + " ";
        }

        return s;
    }

    //Test client for Queue
    public static void main(String[] args) {
        Queue myQueue = new Queue();
        
        myQueue.enqueue("Test");
        myQueue.enqueue("Test2");
        StdOut.println(myQueue.dequeue());
        StdOut.println(myQueue.dequeue());
        myQueue.enqueue("Test3");
        StdOut.println(myQueue.dequeue());
        
    } //End main
} //End Queue
