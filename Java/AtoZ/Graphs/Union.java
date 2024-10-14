package Java.AtoZ.Graphs;

public class Union {
    private int[] rank;
    private int[] parent;
    private int[] size;

    Union(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]);
    }

    void unionBySize(int x, int y) {
        int upX = findParent(x);
        int upY = findParent(y);

        if (upX == upY)
            return;

        if (size[upX] < size[upY]) {
            parent[upX] = upY;
            size[upY] += size[upX];
        } else {
            parent[upY] = upX;
            size[upX] += size[upY];
        }
    }

    void unionByRank(int nodeA, int nodeB) {
        int parentOfA = findParent(nodeA);
        int parentOfB = findParent(nodeB);

        if (parentOfA == parentOfB)
            return;

        if (rank[parentOfA] < rank[parentOfB]) {
            parent[parentOfA] = parentOfB;
        } else if (rank[parentOfB] < rank[parentOfA]) {
            parent[parentOfB] = parentOfA;
        } else {
            parent[parentOfB] = parentOfA;
            parentOfA++;
        }
    }
}
