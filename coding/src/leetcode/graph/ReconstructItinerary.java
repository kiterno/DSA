package leetcode.graph;

import java.util.*;

public class ReconstructItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        Map<String, PriorityQueue<String>> notInMap = new HashMap<>();

        List<String> result = new ArrayList<>();
        for(List<String> ticket: tickets) {
            String u = ticket.get(0);
            map.put(u, new PriorityQueue<>(String::compareTo));
            notInMap.put(u, new PriorityQueue<>(String::compareTo));
        }

        for(List<String> ticket: tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            if (map.containsKey(v)) {
                PriorityQueue<String> pq = map.get(u);
                pq.add(v);
                map.put(u, pq);
            } else {
                PriorityQueue<String> pq = notInMap.get(u);
                pq.add(v);
                notInMap.put(u, pq);
            }
        }
        System.out.println(map);
        System.out.println(notInMap);
        Queue<String> queue = new LinkedList<>();
        queue.add("JFK");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            result.add(curr);
            if (map.containsKey(curr) && !map.get(curr).isEmpty()) {
                queue.add(map.get(curr).poll());
            } else if (notInMap.containsKey(curr) && !notInMap.get(curr).isEmpty()) {
                queue.add(notInMap.get(curr).poll());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String >> list = new ArrayList<>();

        String[][] input = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
        for(String[] s: input) {
            List<String> l1 = new ArrayList<>();
            l1.add(s[0]);l1.add(s[1]);
            list.add(l1);
        }
        System.out.println(findItinerary(list));
    }
}

// ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","TIA","AUA","AXA","TIA","ADL","EZE","HBA"]
// ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","TIA","ADL","EZE","HBA"]