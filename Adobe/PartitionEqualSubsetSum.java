// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int n, int arr[])
    {
        // code here
        int sum = 0;
        for(int val:arr){
            sum+=val;
        }
        if(sum%2==1){
            return 0;
        }
        boolean[][]dp = new boolean[n+1][sum/2 + 1];
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j==0){
                    dp[i][j] = true;
                }else{
                    if(dp[i-1][j]==true)
                    dp[i][j] = true;
                    if(j>=arr[i-1]){
                        if(dp[i-1][j-arr[i-1]]==true){
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        if(dp[n][sum/2]==true){
            return 1;
        }else{
            return 0;
        }
    }
}
/*Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explaination: 
The two parts are {1, 5, 5} and {11}.
Example 2:

Input: N = 3
arr = {1, 3, 5}
Output: NO
Explaination: This array can never be 
partitioned into two such parts.*/