package lesson3;

public class MyDequeue<T> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDequeue(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (T[]) new Object[capacity];
    }

    public MyDequeue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index){

        return (index + 1) % list.length;
    }

    private int prevIndex(int index){

        return (index + list.length - 1) % list.length;
    }

    public T peekLeft(){

        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return list[begin];
    }

    public T peekRight(){

        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return list[end];
    }

    public void insertRight(T item){
        if(isFull()){
            extend();
        }
        size++;
        end = nextIndex(end);
        list[end] = item;
    }

    public void insertLeft(T item){
        if(isFull()){
            extend();
        }
        size++;
        begin = prevIndex(begin);
        list[begin] = item;
    }

    public T removeLeft(){
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight(){
        T temp = peekRight();
        size--;
        list[end] = null;
        end = prevIndex(end);
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
            System.arraycopy(list, 0, newList, list.length - begin, begin);
        }
        begin = 0;
        end = size - 1;
        list = newList;
    }

}
