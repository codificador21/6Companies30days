// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]visited = new boolean[n][m];
        int sum = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(visited[i][j]==false && grid[i][j] == 1){
                    sum = Math.max(sum,dfs(grid,visited,i,j));
                }
            }
        }
        return sum;
    }
    public static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int dfs(int[][]grid,boolean[][]visited,int i,int j){
        
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(i,j));
        int size = 0;
        while(que.size()>0){
            Pair rem = que.remove();
           
            if(visited[rem.x][rem.y] == false){
                size++;
            }else{
                continue;
            }
            
            visited[rem.x][rem.y] = true;
            for(int[] dir:dirs){
                int x = rem.x+dir[0];
                int y = rem.y+dir[1];
                if(x<grid.length && y<grid[0].length && x>=0 && y>=0 &&
                grid[x][y]==1 && visited[x][y]==false){
                    que.add(new Pair(x,y));
                }
            }
        }
        return size;
    }
    
}
/*of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored
in orange.
Example 2:

Input: grid = {{0,1}}
Output: 1
Explanation: The grid is-
0 1
The largest region of 1's is colored in 
orange.*/