class Solution {
    HashSet<String> pacific = new HashSet<>();
    HashSet<String> atlantic = new HashSet<>();

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        for (int i = 0; i < COLS; i++) {
            dfs(new int[]{0, i}, heights, true);
            dfs(new int[]{ROWS - 1, i}, heights, false);
        }

        for (int j = 0; j < ROWS; j++) {
            dfs(new int[]{j, 0}, heights, true);
            dfs(new int[]{j, COLS - 1}, heights, false);
        }

        pacific.retainAll(atlantic);
        List<List<Integer>> result = new ArrayList<>();

        for (String coord : pacific) {
            String[] parts = coord.split(",");
            result.add(Arrays.asList(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }
        return result;
    }

    private void dfs(int[] coords, int[][] heights, boolean pac) {
        String key = coords[0] + "," + coords[1];
        if (pac) {
            if (pacific.contains(key)) return;
            pacific.add(key);
        } else {
            if (atlantic.contains(key)) return;
            atlantic.add(key);
        }
        for (int[] direction : directions) {
            int[] new_coords = {coords[0] + direction[0], coords[1] + direction[1]};
            if (new_coords[0] >= 0 
            && new_coords[0] < heights.length 
            && new_coords[1] >= 0 
            && new_coords[1] < heights[0].length
            && heights[new_coords[0]][new_coords[1]] >= heights[coords[0]][coords[1]]) {
                dfs(new_coords, heights, pac);
            }
        }
    }
}
