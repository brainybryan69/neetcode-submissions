class Solution {
    public int swimInWater(int[][] grid) {
        int[][] neighbors = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[] {grid[0][0], 0, 0});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int x = curr[1], y = curr[2];
            if (curr[0] > dist[x][y]) continue;

            for (int[] neighbor : neighbors) {
                int nextx = x + neighbor[0];
                int nexty = y + neighbor[1];
                if (nextx < 0 || nexty < 0 || nextx >= grid.length || nexty >= grid[0].length) continue;
                
                int newDist = Math.max(dist[x][y], grid[nextx][nexty]);
                if (newDist < dist[nextx][nexty]) {
                    dist[nextx][nexty] = newDist;
                    heap.offer(new int[] {newDist, nextx, nexty});
                }
            }
        }
        return dist[grid.length - 1][grid[0].length - 1];
    }
}
