package Java.AtoZ.Greedy;

public class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }

    @Override
    public String toString() {
        return this.value + " - " + this.weight;
    }
}
