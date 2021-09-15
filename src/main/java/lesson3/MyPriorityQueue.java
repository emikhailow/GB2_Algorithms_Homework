package lesson3;

import java.util.EmptyStackException;

public class MyPriorityQueue<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyPriorityQueue(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {

        list = (T[]) new Comparable[DEFAULT_CAPACITY];
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

    public void insert(T item){
        if(isFull()){
            extend();
        }
        list[size] = item;
        size++;
        int i = size - 1;
        while(i > 0 && list[i].compareTo(list[i - 1]) > 0){
            swap(i, i - 1);
            i--;
        }
    }

    private void extend() {
        int newCapacity = (int) Math.floor(list.length * 1.5 + 1);
        T[] newList = (T[]) new Comparable[newCapacity];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    public T remove(){
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    private void swap(int index1, int index2){
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

}



