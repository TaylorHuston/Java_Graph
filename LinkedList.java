/*
 Linked List Implementation, 
Based on Section 1.3 of Algorithms, 4th Edition
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    //Holds the name of the list, if applicable
    private String name;  
    private Node head;
    private Node tail;

    //Constructor without name
    public LinkedList() {
        this("N/A");
    } //End Constructor
    
    //Constructor with name
    public LinkedList(String name) {
        this.name = name;
        head = null;
        tail = head;
    } //End one-arguement Constructor
    
    //The nodes for the list
    private class Node {

        //The generic data the nodes contain
        private T data;  
        private Node next;
        private Node prev;
        
        //Node constructor
        public Node(T newData) {
            data = newData;
            next = null;
            prev = null;
        } //End Constructor

        @Override
        //toString method
        public String toString() {
            return data.toString();
        }

        //Deletes a node
        private void deleteNode() {  
            if (this.prev != null) {
                this.prev.next = this.next;
            }
            if (this.next != null) {
                this.next.prev = this.prev;
            }
        } //End deleteNode
    } //End Node

    //Checks if the list is empty
    public boolean isEmpty() {
        return head == null;
    } //End isEmpty
    
    //Adds node to end of list, for a push
    public void addToEnd(T newData) {
        
        //If it's the first (or all of the nodes have been removed)
        if (isEmpty()) {  
            head = new Node(newData);
            tail = head;
        } else {
            tail.next = new Node(newData);
            tail.next.prev = tail;
            tail = tail.next;
        }
    } //End addToEnd

    //Removes node from end of list, for a pop or dequeue
    public T removeFromEnd() {
        
        //Trying to remove when there's no nodes left
        if (isEmpty()) throw new NoSuchElementException("List empty"); 
        
        T toReturn = tail.data;
        
        if (tail != head) {  //If there's more then one node left
            tail = tail.prev;
            tail.next = null;
        } else {  //Remove the last node
            tail = head = null;
        }
        
        return toReturn;
    } //End removeFromEnd

    //Adds node to beginning of list, for a queue
    public void addToFront(T newData) {
        
        //If it's the first (or all of the nodes have been removed)
        if (isEmpty()) {  
            head = new Node(newData);
            tail = head;
        } else {
            head.prev = new Node(newData);
            head.prev.next = head;
            head = head.prev;
        }
    }

    //Removes node from end of list
    public T removeFromFront() {
        
        //Trying to remove when there's no nodes left
        if (isEmpty()) throw new NoSuchElementException("List empty"); 
        
        T toReturn = head.data;
        head = head.next;
        head.prev.deleteNode();
        
        return toReturn;
    } //End removeFromFront

    //Prints list from head to end
    public void printList() {
        Node currPos = head;
        while (currPos != null) {
            StdOut.print(currPos + " ");
            currPos = currPos.next;
        }
    } //End printList

    //Iterable methods
    public Iterator<T> iterator() {
        return new ListIterator();
    } //End iterator

    private class ListIterator implements Iterator<T> {

        private Node curr = head;

        public boolean hasNext() {
            return curr != null;
        } //End hasNext

        //Not implemented
        public void remove() { }

        public T next() {
            T data = curr.data;
            curr = curr.next;
            return data;
        } //End next
    } //End ListIterator
    
    
    
    //Test client
    public static void main(String[] args) {
        LinkedList<Integer> testLL = new LinkedList<Integer>("Test");

        testLL.addToEnd(3); 
        testLL.addToEnd(4); 
        testLL.addToFront(2); 
        testLL.addToEnd(5); 
        testLL.addToFront(1); 
        printLL(testLL); //1 2 3 4 5
        
        testLL.removeFromEnd();
        testLL.removeFromFront();
        testLL.addToFront(0);
        printLL(testLL); //0 2 3 4   
        
        try {
            testLL.removeFromEnd();
            testLL.removeFromEnd();
            testLL.removeFromEnd();
            testLL.removeFromEnd();
            testLL.removeFromEnd();
        } catch (NoSuchElementException e) {
            StdOut.println("Error when trying to remove from end: "
            + e.getMessage());
        }

    } //End main
    
    static void printLL(LinkedList testLL) {
        Iterator testIterator = testLL.iterator();
        while (testIterator.hasNext()) {
            Object toPrint = testIterator.next();
            StdOut.print(toPrint.toString() + " ");
        }
        StdOut.println();
    } //End printLL
} //End LinkedList