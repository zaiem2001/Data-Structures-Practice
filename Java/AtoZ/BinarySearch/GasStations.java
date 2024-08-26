package Java.AtoZ.BinarySearch;

import java.util.PriorityQueue;

public class GasStations {
    static class Order {
        double val;
        int index;

        public Order(double val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return this.val + ": " + this.index;
        }
    }

    public static double minimiseMaxDist(int stations[], int k) {
        int n = stations.length;
        int[] howMany = new int[n - 1];
        PriorityQueue<Order> pq = new PriorityQueue<>((Order o1, Order o2) -> Double.compare(o2.val, o1.val));

        for (int i = 0; i < n - 1; i++) {
            double difference = stations[i + 1] - stations[i];
            Order o = new Order(difference, i);

            pq.add(o);
        }

        for (int station = 1; station <= k; station++) {
            Order topEl = pq.poll();
            int sIndex = topEl.index;
            howMany[sIndex]++;

            double initialDiff = stations[sIndex + 1] - stations[sIndex];
            double newDiff = initialDiff / (double) (howMany[sIndex] + 1);
            pq.add(new Order(newDiff, sIndex));
        }

        return pq.peek().val;
    }

    public static void main(String[] args) {
        // int[] stations = { 3, 6, 12, 19, 33, 44, 67, 72, 89, 95 };
        int[] stations = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 9;
        System.out.println(minimiseMaxDist(stations, k));
    }
}
