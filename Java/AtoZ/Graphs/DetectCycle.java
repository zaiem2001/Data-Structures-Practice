package Java.AtoZ.Graphs;

public class DetectCycle {
    static boolean detect(int[][] edges, int n) {
        Union dj = new Union(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (dj.findParent(u) == dj.findParent(v))
                return true;

            dj.unionByRank(u, v);
        }

        return false;
    }

    static boolean detect_size(int[][] edges, int n) {
        Union dj = new Union(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (dj.findParent(u) == dj.findParent(v))
                return true;

            dj.unionBySize(u, v);
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 } };
        int n = 4;

        System.out.println(detect(edges, n));
        System.out.println(detect_size(edges, n));
    }
}
