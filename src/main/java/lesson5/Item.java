package lesson5;

public class Item {
    private int weight;
    private int price;
    private String name;

    private static int count = 0;

    public Item(int weight, int price) {
        count++;
        this.weight = weight;
        this.price = price;
        this.name = String.format("Item %d", count);
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%dkg, %d$)", this.name, this.weight, this.price);
    }
}
