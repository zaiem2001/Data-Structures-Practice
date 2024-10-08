package Java.AtoZ.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

    static ArrayList<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        // Code here
        ArrayList<Integer> output = new ArrayList<>();
        dfs(adj, new HashSet<>(), 0, output);

        return output;
    }

    public static void main(String[] args) {
        int[][] adj = { { 2, 3, 1 }, { 0 }, { 0, 4 }, { 0 }, { 2 } };
        System.out.println(dfsOfGraph(5, Helpers.convertIntToList(adj)));
    }
}
