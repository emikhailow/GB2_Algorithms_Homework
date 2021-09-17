package lesson3;

import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (T[]) new Object[capacity];
    }

    public MyStack() {

        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int size(){

        return size;
    }

    public boolean isEmpty(){

        return size == 0;
    }

    public boolean isFull(){

        return size == list.length;
    }

    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void push(T item){
        if(isFull()){
            extend();
        }
        list[size] = item;
        size++;
    }

    private void extend() {
        int newCapacity = (int) Math.floor(list.length * 1.5 + 1);
        T[] newList = (T[]) new Object[newCapacity];
        System.arraycopy(list, 0 , newList, 0, size);
        list = newList;
    }

    public T pop(){
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    private void reCapacity(int newSize){
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }
}
