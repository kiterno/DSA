package leetcode.practice.graph;

import java.util.*;

public class ReconstructItienarary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();

        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket: tickets) {
            String u = ticket.get(0), v = ticket.get(1);

            PriorityQueue<String> pu = adj.getOrDefault(u, new PriorityQueue<>());
            pu.add(v);
            adj.put(u, pu);
        }

        System.out.println(adj);
        dfs(adj, result, "JFK");
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, List<String> result, String curr) {
        result.add(curr);

        PriorityQueue<String> pq = adj.get(curr);

        while(pq!=null && !pq.isEmpty()) {
            dfs(adj, result, pq.poll());
        }
    }


    public static void main(String[] args) {
//        List<List<String>> tickets = List.of(List.of("MUC", "LHR"), List.of("JFK","MUC"), List.of("SFO","SJC"), List.of("LHR","SFO"));
//        System.out.println(new ReconstructItienarary().findItinerary(tickets));
//        List<List<String>> tickets2 = List.of(List.of("JFK","SFO"), List.of("JFK","ATL"), List.of("SFO","ATL"), List.of("ATL","JFK"), List.of("ATL","SFO"));
//        System.out.println(new ReconstructItienarary().findItinerary(tickets2));
//        System.out.println(new ReconstructItienarary().findItineraryLeet(tickets2));

        List<List<String>> tickets3 = List.of( List.of("JFK","KUL"), List.of("JFK","NRT"), List.of("NRT","JFK"));
        System.out.println(new ReconstructItienarary().findItineraryLeet(tickets3));

    }

    public List<String> findItineraryLeet(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0),
                    k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        System.out.println(graph);
        LinkedList<String> stack = new LinkedList<>();
        stack.add("JFK");
        LinkedList<String> itinerary = new LinkedList<>();

        while(!stack.isEmpty()){
            while(!graph.getOrDefault(stack.peekLast(), new PriorityQueue<>()).isEmpty()){
                stack.add(graph.get(stack.peekLast()).poll());
            }
            System.out.println(stack);
            itinerary.addFirst(stack.pollLast());
            System.out.println(itinerary+" " + stack);
        }
        return itinerary;
    }
}
