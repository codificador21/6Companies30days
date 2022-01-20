// { Driver Code Starts
//Initial Template for Java
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    static long numOfWays(int n, int x)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int num = 0;
        for(int i = 0;i<=n && num<=n;i++){
            num = (int)(Math.pow(i,x));
            list.add(num);
        }
        int sz = list.size();
        long[][]dp = new long[sz+1][n+1];
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                }else if(i==0){
                    dp[i][j] = 0;
                }else if(j==0){
                    dp[i][j] = 1;
                }else{
                    if(list.get(i-1)>j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j]+dp[i-1][j-list.get(i-1)];
                    }
                }
            }
        }
        
        return dp[sz][n];
    }
}
/*Given two numbers n and x, find out the total number of ways n can be expressed as sum of xth power of unique natural numbers.

Example 1:

Input: n = 10, x = 2
Output: 1 
Explanation: 10 = 12 + 32, Hence total 1 possibility. 

Example 2:

Input: n = 100, x = 2
Output: 3
Explanation: 100 = 102 
62 + 82 and 12 + 32 + 42 + 52 + 72 
Hence total 3 possibilities. */