package lesson3;

import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int randomCapacity = random.nextInt(10);

        //1. Создать класс для реализации дека.

        //заполняем dequeue количеством элементов на 1 больше, чем вместимость,
        //и убеждаемся, что dequeue заполнилась
        MyDequeue<Integer> myDequeue = new MyDequeue<>(randomCapacity);
        for(int i = 0; i < randomCapacity + 1; i++)
        {
            if(random.nextBoolean()){
                myDequeue.insertLeft(i);
            } else{
                myDequeue.insertRight(i);
            }
        }

        for(int i = 0; i < randomCapacity + 1; i++){
            if(random.nextBoolean()){
                myDequeue.removeLeft();
            } else{
                myDequeue.removeRight();
            }
        }

        //2. Создать программу, которая переворачивает вводимые строки (читает справа налево)

        MyStack<Character> myCharStack = new MyStack<>(randomCapacity);
        String initialString = "some test string";
        System.out.println(String.format("Initial string: %s", initialString));
        for(int i = 0; i < initialString.length(); i++){
            myCharStack.push(initialString.charAt(i));
        };
        StringBuilder sb = new StringBuilder("");
        while(!myCharStack.isEmpty()){
            sb.append(myCharStack.pop());
        }
        System.out.println(String.format("Reversed string: %s", sb.toString()));

        //3. Прикрутить увеличение массива в классе стек и приоритетная очередь

        //заполняем стек количеством элементов на 1 больше, чем вместимость,
        //и убеждаемся, что стек заполнился
        MyStack<Integer> myStack = new MyStack<>(randomCapacity);
        for (int i = 0; i < randomCapacity + 1; i++) {
            myStack.push(i);
        }
        for(int i = 0; i < randomCapacity + 1; i++){
            System.out.println((myStack.pop()));
        }

        //заполняем приоритетную очередь количеством элементов на 1 больше, чем вместимость,
        //и убеждаемся, что dequeue заполнилась
        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>(randomCapacity);
        for(int i = 0; i < randomCapacity + 1; i++)
        {
            myPriorityQueue.insert(random.nextInt(100));
        }

        //4***. Реализовать метод увеличивающий массив в классе очередь

        //заполняем очередь количеством элементов на 1 больше, чем вместимость,
        //и убеждаемся, что очередь заполнилась
        MyQueue<Integer> myQueue = new MyQueue<>(randomCapacity);
        for(int i = 0; i < randomCapacity + 1; i++)
        {
            myQueue.insert(random.nextInt(100));
        }

    }
}
