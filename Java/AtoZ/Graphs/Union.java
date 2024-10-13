package Java.AtoZ.Graphs;

public class Union {
    int[] rank;
    int[] parent;

    Union(int n) {
        this.rank = new int[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int findParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = findParent(parent[node]);
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
