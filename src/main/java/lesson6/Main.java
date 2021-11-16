package lesson6;

import java.util.Random;

public class Main {

    public static final int TREE_MAP_COUNT = 20;
    public static Random random = new Random();

    public static void main(String[] args) {
        int balancedTreesCount = 0;
        for (int i = 0; i < TREE_MAP_COUNT; i++) {
            MyTreeMap<Integer, String> myTreeMap = new MyTreeMap<>();
            while(myTreeMap.height() < 6){
                int key = (random.nextBoolean() ? 1 : -1) * random.nextInt(101);
                myTreeMap.put(key, String.valueOf(key));
            }
            if(myTreeMap.isBalanced()){
                balancedTreesCount++;
            }
        }

        System.out.println(String.format("%.2f%%", 100 * (double) balancedTreesCount / TREE_MAP_COUNT));
    }
}
