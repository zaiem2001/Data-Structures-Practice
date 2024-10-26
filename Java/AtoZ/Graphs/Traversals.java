package Java.AtoZ.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Java.Utility.Helpers;

public class Traversals {

    static void dfs(List<List<Integer>> adj, HashSet<Integer> visited, int node, ArrayList<Integer> output) {

        output.add(node);
        visited.add(node);

        List<Integer> children = adj.get(node);

        for (int i = 0; i < children.size(); i++) {
            int childNode = children.get(i);

            if (!visited.contains(childNode)) {
                dfs(adj, visited, childNode, output);
            }

        }

        return;
    }

    static void backTrack(int node, int target, List<Integer> path, int[][] graph, List<List<Integer>> results) {
        if (node == target) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int adjNode : graph[node]) {
            path.add(adjNode);
            backTrack(adjNode, target, path, graph, results);
            path.remove(path.size() - 1);
        }

    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<List<Integer>> results = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(0);

        backTrack(0, target, path, graph, results);

        return results;
    }

    static ArrayList<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        // Code here
        ArrayList<Integer> output = new ArrayList<>();
        dfs(adj, new HashSet<>(), 0, output);

        return output;
    }

    static void bfs(int[][] adj) {
        int n = adj.length;
        int[] visited = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = 1;
        List<Integer> output = new ArrayList<>();

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            output.add(currentNode);

            for (int child : adj[currentNode]) {
                if (visited[child] == 0) {
                    q.offer(child);
                    visited[child] = 1;
                }
            }

        }

        System.out.println("BFS..");
        System.out.println(output);
    }

    public static void main(String[] args) {
        int[][] adj = { { 2, 3, 1 }, { 0 }, { 0, 4 }, { 0 }, { 2 } };
        System.out.println(dfsOfGraph(5, Helpers.convertIntToList(adj)));
        bfs(adj);

        int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
        System.out.println(allPathsSourceTarget(graph));
    }
}
