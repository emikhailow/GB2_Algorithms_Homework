package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private int capacity;
    private List<Item> itemList;
    private int[][] matrix;
    private int value;

    public Knapsack(int capacity) {
        this.capacity = capacity;
    }

    public void solve(List<Item> itemList) {
        int itemsCount = itemList.size();
        matrix = new int[itemsCount + 1][this.capacity + 1];

        for (int j = 0; j < this.capacity; j++) {
            matrix[0][j] = 0;
        }

        for (int i = 1; i <= itemsCount; i++) {
            for (int j = 0; j <= this.capacity; j++) {
                Item currentItem = itemList.get(i - 1);
                int currentWeight = currentItem.getWeight();
                int currentPrice = currentItem.getPrice();
                if(currentWeight > j){
                    matrix[i][j] = matrix[i - 1][j];
                }else{
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - currentWeight] + currentPrice);
                }
            }
        }

        this.value = matrix[itemsCount][this.capacity];

        this.itemList = new ArrayList<>();
        putItems(itemList, itemsCount, this.capacity);
    }

    public void putItems(List<Item> itemList, int i, int j){
        if(this.matrix[i][j] == 0){
            return;
        }
        if(this.matrix[i - 1][j] == this.matrix[i][j]){
            putItems(itemList, i - 1, j);
        } else{
            putItems(itemList, i - 1, j - itemList.get(i - 1).getWeight());
            this.itemList.add(itemList.get(i - 1));
        }
    }

    public int getValue() {
        return value;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
