package lesson2;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;

    private int index(T item){
        for(int i = 0; i < size; i++){
            if(list[i] != null && list[i].equals(item)){
                return i;
            }

        }
        return -1;
    }

    private int indexOf(T item){
        return index(item);
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <=0");
        }
        list = (T[]) new Comparable[capacity];
        this.capacity = capacity;
   }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public MyArrayList(MyArrayList<T> myArrayList) {
        list = (T[]) new Comparable[myArrayList.getCapacity()];
        capacity = myArrayList.getCapacity();
        for(int i = 0; i < myArrayList.getSize(); i++){
            list[i] = myArrayList.get(i);
            size++;
        }
    }

    public void add(T item) {
        capacityCheck();
        list[size] = item;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public void add(int index, T item){
        checkIndex(index);
        capacityCheck();
        for(int j = size - 1; j > index; j--){
            list[j] = list[j-1];
        }
        list[index] = item;
        size++;
    }

    public void remove(int index){
        checkIndex(index);
        for(int i = index; i < size + 1; i++){
            list[i] = list[i + 1];
        }
    }

    public void remove(T item){
        int index = indexOf(item);
        if(index >= 0) {
            remove(index);
        }
    }

    public int getSize() {
        return size;
    }

    public T get(int index){
        checkIndex(index);
        return list[index];
    }

    private boolean less(T item1, T item2){
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2){
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort(){
        int imin;
        for(int i = 0; i < size - 1; i++){
            imin = i;
            for(int j = i + 1; j < size; j++){
                if(less(list[j], list[imin])){
                    imin = j;
                }
            }
            swap(i, imin);
        }
    }

    public void insertionSort(){
        T key;
        for(int i = 1; i < size; i++){
            int j = i;
            key = list[i];
            while(j > 0 && less(key, list[j - 1])){
                list[j] = list[j - 1];
                j--;
            }
        }
    }

    public void bubbleSort(){
        for(int i = size - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(less(list[j + 1], list[i])){
                    swap(j + 1, j);
                }
            }
        }
    }

    public int getCapacity() {
        return capacity;
    }

    private void capacityCheck(){
        if(size == capacity){
            capacity = (int) Math.floor(list.length * 1.5 + 1);
            T[] newList = (T[]) new Comparable[capacity];
            for (int i = 0; i < size; i++){
                newList[i] = list[i];
            }
            list = newList;
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}









