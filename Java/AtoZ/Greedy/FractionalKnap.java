package Java.AtoZ.Greedy;

import java.util.Arrays;

public class FractionalKnap {
    static double findKnap(Item[] items, int w, int n) {
        double totalValue = 0;
        Arrays.sort(items,
                (item1, item2) -> (item2.value / item2.weight) - (item1.value / item1.weight));

        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];
            if (w < currentItem.weight) {
                double perItemWeight = currentItem.value / currentItem.weight;
                totalValue += perItemWeight * w;
                break;
            }
            totalValue += currentItem.value;
            w -= currentItem.weight;
        }

        return totalValue;
    }

    public static void main(String[] args) {

        Item[] items = new Item[] { new Item(60, 10), new Item(100, 20) };
        int w = 50;
        System.out.println(findKnap(items, w, items.length));
    }
}
