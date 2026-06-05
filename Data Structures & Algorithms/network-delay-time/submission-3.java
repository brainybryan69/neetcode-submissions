class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // initialising minheap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // initialising dist array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // initialising adjacency list
        List<List<int[]>> adj_list = new ArrayList<>();
        for (int i = 0; i < n + 1; i ++) adj_list.add(new ArrayList<>());
        for (int[] time : times) adj_list.get(time[0]).add(new int[] {time[1], time[2]});

        heap.offer(new int[] {k, 0});

        while (!heap.isEmpty()) {
            int[] closest = heap.poll();
            int node = closest[0], distance = closest[1];
            if (distance > dist[node]) continue; // check if theres a shorter path
            dist[node] = distance;
            
            // add neighbors to heap
            for (int[] neighbor : adj_list.get(node)) {
                int newDist = distance + neighbor[1];
                if (newDist < dist[neighbor[0]]) {
                    dist[neighbor[0]] = newDist;
                    heap.offer(new int[] {neighbor[0], newDist});
                }
            }
        }
        int maxDist = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
}
