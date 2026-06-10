class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // initialising adjacency matrix, string -> min heap
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String source = ticket.get(0), dest = ticket.get(1);
            adj.computeIfAbsent(source, k -> new PriorityQueue<>()).offer(dest);
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", adj, result);
        return result;
    }

    private void dfs(String curr, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> result) {
        PriorityQueue<String> neighbors = adj.get(curr);
        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(neighbors.poll(), adj, result);
        }
        result.addFirst(curr);
    }
}
