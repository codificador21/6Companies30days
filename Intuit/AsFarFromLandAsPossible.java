class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<pair> que = new ArrayDeque<>();
        int max = -1;
        boolean[][]visited = new boolean[n][n];
        int onecnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] ==1){
                    onecnt++;
                    que.add(new pair(i,j));
                    visited[i][j] = true;
                }
            }
        }
        if(onecnt==n*n){
            return -1;
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(que.size()>0){
            int size = que.size();
            while(size-->0){
                pair rem = que.poll();                
                
                for(int[]dir:dirs){
                    int x = rem.x+dir[0];
                    int y = rem.y+dir[1];
                    if(x>=0 && y>=0 && x<n && y<n && visited[x][y]==false){
                        visited[x][y] = true;
                        que.add(new pair(x,y));
                    }
                }
            }
            max++;
        }
        return max;
        
    }
    public class pair{
        int x;
        int y;
        pair(int a,int b){
            x=a;
            y=b;
        }
    }
}
/*Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 

Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:


Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1*/