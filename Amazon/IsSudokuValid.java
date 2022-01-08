// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isValid(int arr[][]){
        // code here
        int[][] x = new int[9][9];
        int[][] y = new int[9][9];
        int[][] sq = new int[9][9];
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(arr[i][j]==0) continue;
                int num = arr[i][j]-1;
                if(x[num][i]==1 || y[num][j]==1 || sq[num][(i/3)*3 + j/3]==1){
                    return 0;
                }else{
                    x[num][i]=1;
                    y[num][j]=1;
                    sq[num][(i/3)*3 + j/3]=1;
                }
                
            }
        }
        
        return 1;
    }
}
/*Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix(mat[][]) the task to check if the current configuration is valid or not where a 0 represents an empty block.
Note: Current valid configuration does not ensure validity of the final solved sudoku. 
Refer to this : https://en.wikipedia.org/wiki/Sudoku

Example 1:

Input: mat[][] = [
[3, 0, 6, 5, 0, 8, 4, 0, 0]
[5, 2, 0, 0, 0, 0, 0, 0, 0]
[0, 8, 7, 0, 0, 0, 0, 3, 1]
[0, 0, 3, 0, 1, 0, 0, 8, 0]
[9, 0, 0, 8, 6, 3, 0, 0, 5]
[0, 5, 0, 0, 9, 0, 6, 0, 0]
[1, 3, 0, 0, 0, 0, 2, 5, 0]
[0, 0, 0, 0, 0, 0, 0, 7, 4]
[0, 0, 5, 2, 0, 6, 3, 0, 0]
]
Output: 1
Explaination: It is possible to have a
proper sudoku.*/