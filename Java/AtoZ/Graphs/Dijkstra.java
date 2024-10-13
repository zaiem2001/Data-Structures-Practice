package Java.AtoZ.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static void getShortestPath(int[][][] adj, int v, int s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(s, 0));

        int[] distance = new int[v];

        int[] path = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
            path[i] = i;
        }

        distance[s] = 0;

        while (!pq.isEmpty()) {
            Pair currentPair = pq.poll();
            int currentNode = currentPair.node;
            int nodeDistance = currentPair.distance;

            for (int i = 0; i < adj[currentNode].length; i++) {
                int edgeWeight = adj[currentNode][i][1];
                int adjNode = adj[currentNode][i][0];

                if (nodeDistance + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = nodeDistance + edgeWeight;
                    path[adjNode] = currentNode;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }

            }

        }

        int dst = v - 1;
        List<Integer> shortestPath = new ArrayList<>();

        while (path[dst] != dst) {
            shortestPath.add(dst);
            dst = path[dst];
        }

        shortestPath.add(s);

        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(path));
        System.out.println(shortestPath.reversed());

    }

    public static void main(String[] args) {
        int[][][] adj = {
                { { 1, 1 }, { 2, 6 }, { 3, 8 } },
                { { 2, 3 }, { 0, 1 }, { 4, 5 } },
                { { 1, 3 }, { 0, 6 }, { 5, 3 }, { 6, 1 } },
                { { 0, 8 }, { 6, 1 } },
                { { 1, 5 } },
                { { 2, 3 }, { 6, 2 } },
                { { 2, 1 }, { 3, 1 }, { 5, 2 } }
        };

        int v = adj.length;

        getShortestPath(adj, v, 0);
    }
}

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}