package lesson2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n = 100000;
        long startTime;
        Random random = new Random();
        MyArrayList<Integer> myArrayList = new MyArrayList<>(n);
        for (int i = 0; i < n; i++) {
            myArrayList.add(random.nextInt(10));
        }

        MyArrayList<Integer> myArrayList1 = new MyArrayList<>(myArrayList);
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>(myArrayList);
        MyArrayList<Integer> myArrayList3 = new MyArrayList<>(myArrayList);

        startTime = System.currentTimeMillis();
        myArrayList1.selectionSort();
        System.out.println(String.format("Selection sort estimated time: %f", (System.currentTimeMillis() - startTime) / 1000F));

        startTime = System.currentTimeMillis();
        myArrayList2.insertionSort();
        System.out.println(String.format("Insertion sort estimated time: %f", (System.currentTimeMillis() - startTime) / 1000F));

        startTime = System.currentTimeMillis();
        myArrayList3.bubbleSort();
        System.out.println(String.format("Bubble sort estimated time: %f", (System.currentTimeMillis() - startTime) / 1000F));

    }
}
