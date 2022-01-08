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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends



class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid)
    {
        // Code here
        LinkedList<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.addLast(new Pair(i,j));
                }if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        
        int level = 0;
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        
        while(queue.size()>0){
            int sz = queue.size();
            while(sz-->0){
                Pair rem = queue.remove();
                for(int i = 0;i<dirs.length;i++){
                    int x = rem.x+dirs[i][0];
                    int y = rem.y+dirs[i][1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                        queue.add(new Pair(x,y));
                        grid[x][y] = 0;
                        fresh--;
                    }
                }
                
            }
            level++;
        }
        if(fresh==0){
            return level-1;
        }else{
            return -1;
        }
    }
}
/*Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).*/