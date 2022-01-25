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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int[][]dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        boolean[][]visited = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    visited[i][j] = true;
                    boolean bool = dfs(board,word,i,j,""+word.charAt(0),dirs,1,visited);
                    if(bool){
                        return bool;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][]board,String word,int i,int j,String wsf,int[][]dirs,int idx,boolean[][]visited){
        if(wsf.equals(word)){
            return true;
        }
        for(int[]dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x<board.length && y<board[0].length && x>=0 && y>=0 && board[x][y]==word.charAt(idx)&&visited[x][y]==false){
                visited[x][y]=true;
                boolean bool = dfs(board,word,x,y,wsf+word.charAt(idx),dirs,idx+1,visited);
                // System.out.println(wsf);
                if(bool){
                    return bool;
                }
                visited[x][y]=false;
            }
            
        }
        return false;
    }
}
/*Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.
 

Example 1:

Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the
"geeks" are colored.
Example 2:

Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0*/