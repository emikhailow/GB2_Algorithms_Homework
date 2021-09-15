package lesson3;

import java.lang.reflect.Array;

public class MyQueue<T> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyQueue(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index){
         return (index + 1) % list.length;
    }

    public T peekFront(){

        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return list[begin];
    }

    public void insert(T item){
        if(isFull()){
            extend();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove(){
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
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

    private void extend(){
        int newCapacity = (int) Math.floor(list.length * 1.5 + 1);
        T[] newList = (T[]) new Object[newCapacity];
        if(end > begin){
            System.arraycopy(list, begin, newList, 0, size);
        } else {
            System.arraycopy(list, begin, newList, 0, list.length - begin);
            System.arraycopy(list, 0, newList, list.length - begin + 1, end);
        }
        begin = 0;
        end = list.length;
        list = newList;
    }

}
