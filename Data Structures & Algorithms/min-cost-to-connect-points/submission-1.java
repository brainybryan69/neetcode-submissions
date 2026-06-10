class Solution {
    int[] parent, rank;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;
        if (rank[px] < rank[py]) parent[px] = py;
        else {
            parent[py] = px;
            if (rank[px] == rank[py]) rank[px]++;
        }
        return true;
    }

    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        parent = new int[len];
        rank = new int[len];
        for (int i = 0; i < len; i++) parent[i] = i;
        
        PriorityQueue<int[]> edges = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p1 = points[i], p2 = points[j];
                int dist = distance(p1, p2);
                edges.offer(new int[] {dist, i, j});
            }
        }

        int cost = 0, edgesUsed = 0;
        while (!edges.isEmpty()) {
            int[] edge = edges.poll();
            if (union(edge[1], edge[2])) {
                cost += edge[0];
                edgesUsed++;
                if (edgesUsed == len - 1) break;
            }
        }
        return cost;
    }

    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
