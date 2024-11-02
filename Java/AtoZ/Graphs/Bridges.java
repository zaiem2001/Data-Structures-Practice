package Java.AtoZ.Graphs;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    private static List<List<Integer>> criticalConnectionList = new ArrayList<>();
    private static int[] visited;
    private static int[] timeOfInsertion;
    private static int[] lowestTimeOfInsertion;

    static int timer = 1;

    static void buildAdjList(List<List<Integer>> adjList, int[][] edges, int n) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    static void dfs(int node, List<List<Integer>> adjList, int parent) {

        visited[node] = 1;
        timeOfInsertion[node] = lowestTimeOfInsertion[node] = timer++;

        for (int neighbour : adjList.get(node)) {
            if (neighbour == parent)
                continue;

            if (visited[neighbour] == 0) {
                dfs(neighbour, adjList, node);

                lowestTimeOfInsertion[node] = Math.min(lowestTimeOfInsertion[node], lowestTimeOfInsertion[neighbour]);

                if (timeOfInsertion[node] < lowestTimeOfInsertion[neighbour]) {
                    criticalConnectionList.add(List.of(node, neighbour));
                }

            } else {
                lowestTimeOfInsertion[node] = Math.min(lowestTimeOfInsertion[node], lowestTimeOfInsertion[neighbour]);
            }

        }

    }

    static void findBridges(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        buildAdjList(adjList, edges, n);

        visited = new int[n];
        timeOfInsertion = new int[n];
        lowestTimeOfInsertion = new int[n];

        dfs(0, adjList, -1);

        System.out.println(criticalConnectionList);

    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 }, { 3, 4 }, { 0, 4 }, { 2, 5 }, { 0, 6 } };
        int n = 7;

        findBridges(edges, n);
    }
}
