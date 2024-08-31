package Java.AtoZ.Stringss;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqSort {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (Character c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(mp.entrySet());

        StringBuilder answer = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            answer.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
}
