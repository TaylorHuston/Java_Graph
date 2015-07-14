/*
Basic Stack using a Linked List 
Based on Section 1.3 of Algorithms, 4th Edition
*/

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{

    private LinkedList<T> stackList;

    public Stack() {
       stackList = new LinkedList<T>();
    }
    
    //Add to top of stack
    public void push(T toAdd) {
        stackList.addToEnd(toAdd);
    }
    
    //Remove and return from top of stack
    public T pop() {
        return stackList.removeFromEnd();
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    //Iterator
    public Iterator<T> iterator() {
        return stackList.iterator();
    }

    public String toString() {
        String s = "";

        for (T i : stackList) {
            s += i + " ";
        }

        return s;
    }
    //Test client for Stack
    public static void main(String[] args) {

        Stack myStack = new Stack();
        
        myStack.push("Test");
        myStack.push("Test2");
        StdOut.println(myStack.pop());
        StdOut.println(myStack.pop());
        myStack.push("Test3");
        StdOut.println(myStack.pop());

    } //End main
} //End Stack
