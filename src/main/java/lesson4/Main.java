package lesson4;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int COUNT = 10;
        final int MAX_INT = 100;
        Random random = new Random();

        MyLinkedQueue<Integer> myLinkedQueue = new MyLinkedQueue<>();
        for(int i = 0; i < COUNT; i++){
            myLinkedQueue.insert(random.nextInt(MAX_INT));
        }
        System.out.println(myLinkedQueue);

        while(true){
            try{
                System.out.println(myLinkedQueue.remove());
            }
            catch(RuntimeException e){
                break;
            }
        }

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < COUNT; i++) {
            if(random.nextBoolean()){
                myLinkedList.insertFirst(random.nextInt(MAX_INT));
            }else{
                myLinkedList.insertLast(random.nextInt(MAX_INT));
            }
        }
        System.out.println(myLinkedList);

        for (int i = 0; i < COUNT; i++) {
            int randomInt = random.nextInt(MAX_INT);
            System.out.println(String.format("Index of %d is %d", randomInt, myLinkedList.indexOf(randomInt)));
        }
    }
}
