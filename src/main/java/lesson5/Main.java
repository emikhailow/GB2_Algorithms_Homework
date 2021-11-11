package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static long power(long i, int power){
        if(power == 0){
            return 1;
        }
        if(power == 1){
            return i;
        };
        return i * power(i, power - 1);
    }

    public static void main(String[] args) {

        System.out.println(String.format("%d^%d = %d", 2, 3, power(2,3)));

        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(new Item(4, 3000));
        itemList1.add(new Item(3, 2000));
        itemList1.add(new Item(1, 1500));

        Knapsack knapsack1 = new Knapsack(8);

        knapsack1.solve(itemList1);

        System.out.println(String.format("%d$", knapsack1.getValue()));
        System.out.println(String.format("Items list: %s", knapsack1.getItemList()));

        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(new Item(3, 1));
        itemList2.add(new Item(4, 6));
        itemList2.add(new Item(5, 4));
        itemList2.add(new Item(8, 7));
        itemList2.add(new Item(9, 6));

        Knapsack knapsack2 = new Knapsack(13);

        knapsack2.solve(itemList2);

        System.out.println(String.format("%d$", knapsack2.getValue()));
        System.out.println(String.format("Items list: %s", knapsack2.getItemList()));


    }

}
