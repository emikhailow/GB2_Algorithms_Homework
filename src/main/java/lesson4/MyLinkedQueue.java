package lesson4;

import java.util.Iterator;

public class MyLinkedQueue<T>{

    private MyLinkedList<T> list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyLinkedQueue() {
        list = new MyLinkedList<>();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public void insert(T item){
        list.insertLast(item);
        size++;
    }

    public T peekFront(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return list.getFirst();
    }

    public T remove(){
        try{
            return list.removeFirst();
        }catch(RuntimeException e){
            throw new RuntimeException("Queue is empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T t : list) {
            sb.append(t).append(", ");
        }
        if(list.size() > 0){
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

}