package Java.AtoZ.Graphs;

import java.util.HashMap;

public class LcommonSeq {
    static int find(int[] nums) {
        DisjointSet ds = new DisjointSet();

        for (int x : nums) {
            ds.add(x);
        }

        System.out.println(ds.parent);
        System.out.println(ds.size);
        System.out.println(ds.maxSize);

        for (int x : nums) {
            if (ds.parent.containsKey(x + 1)) {
                ds.union(x, x + 1);
            }
        }

        System.out.println("A");
        System.out.println(ds.parent);
        System.out.println(ds.size);
        System.out.println(ds.maxSize);

        return ds.maxSize;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

        System.out.println(find(nums));
    }

}

class DisjointSet {
    HashMap<Integer, Integer> parent;
    HashMap<Integer, Integer> size;
    int maxSize;

    DisjointSet() {
        this.parent = new HashMap<>();
        this.size = new HashMap<>();
        this.maxSize = 0;
    }

    int find(int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    void union(int x, int y) {
        int pX = find(x);
        int pY = find(y);

        if (pX == pY)
            return;

        if (size.get(pX) < size.get(pY)) {
            parent.put(pX, pY);
            size.put(pY, size.get(pX) + size.get(pY));
        } else {
            parent.put(pY, pX);
            size.put(pX, size.get(pX) + size.get(pY));
        }

        this.maxSize = Math.max(maxSize, Math.max(size.get(pX), size.get(pY)));
    }

    // initialize
    void add(int x) {
        if (!this.parent.containsKey(x)) {
            this.parent.put(x, x);
            this.size.put(x, 1);
        }

    }

}