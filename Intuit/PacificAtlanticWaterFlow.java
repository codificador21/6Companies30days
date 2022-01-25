class Solution {
  private int[][] matrix;
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }
    this.matrix = matrix;
    int m = matrix.length, n = matrix[0].length;
    // dp for pacific
    boolean[][] flowToPac = new boolean[m][n];
    boolean[][] visited = new boolean[m][n];
    for (int h = 0; h < m; h++) {
      if (!visited[h][0]) dfs(h, 0, visited, flowToPac);
    }
    for (int w = 0; w < n; w++) {
      if (!visited[0][w]) dfs(0, w, visited, flowToPac);
    }
    // dp for atlantic
    boolean[][] flowToAtl = new boolean[m][n];
    visited = new boolean[m][n];
    for (int h = 0; h < m; h++) {
      if (!visited[h][n - 1]) dfs(h, n - 1, visited, flowToAtl);
    }
    for (int w = 0; w < n; w++) {
      if (!visited[m - 1][w]) dfs(m - 1, w, visited, flowToAtl);
    }
    // convert to result
    List<List<Integer>> res = new ArrayList<>();
    for (int h = 0; h < m; h++) {
      for (int w = 0; w < n; w++) {
        if (flowToAtl[h][w] && flowToPac[h][w]) {
          List<Integer> temp = new ArrayList<>();
          temp.add(h);
          temp.add(w);
          res.add(temp);
        }
      }
    }
    return res;
  }
  private int[][] dirs = {
    {-1, 0}, {1, 0},
    {0, -1}, {0, 1}
  };
  private void dfs(int h, int w, boolean[][] visited, boolean[][] conn) {
    if (visited[h][w]) return;
    conn[h][w] = true;
    visited[h][w] = true;
    for (int[] d: dirs) {
      int newH = h + d[0], newW = w + d[1];
      if (newH >= 0 && newH < matrix.length &&
          newW >= 0 && newW < matrix[0].length &&
          matrix[newH][newW] >= matrix[h][w]) {
        dfs(newH, newW, visited, conn);
      }
    }
  }
}
/*There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

 

Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Example 2:

Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105*/