package StackCollection;

import java.util.EmptyStackException;

public class MyStack<T> {
    private int top;
    private T[] storage;

    public MyStack() {
    }

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack's capacity must be positive");
        }
        storage = (T[]) new Object[capacity];
        top = -1;
    }
    
    public void push(T value){
        if (top == storage.length) {
            throw new StackOverflowError("Stack's underlying storage is overflow");
        }
        top++;
        storage[top] = value;
    }
    
    public void display(){
        System.out.print("Array List = ");
        for (int i = 0; i < storage.length; i++) 
            System.out.print(" " + storage[i]);
            System.out.println();        
    }
    
    public T peek(){
        if (top == -1) 
            throw new EmptyStackException();
        top--;
        return storage[top];
    }
    
    public T pop(){
        if (top == -1) {
            throw new EmptyStackException();
        }
        T tmp = storage[top];
        top--;
        return tmp;
    }
    
    public boolean isEmpty(){
        return (top == -1);
    }
    
    public static void main(String[] args) {
        int[] b = {25,17,26,19,23};
        MyStack t = new MyStack(b.length);
        for (int i = 0; i < b.length; i++) {
            t.push(b[i]); 
        }
        t.display();
        
        System.out.print("ArrayStack = ");
        for (int i = 0; i < b.length; i++) 
            System.out.print(" " + t.pop());
            System.out.println();
        
    }
    
    
    
}
