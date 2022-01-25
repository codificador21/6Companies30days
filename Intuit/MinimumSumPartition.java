// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    for(int val:arr){
	        sum+=val;
	    }
	    boolean[][] dp = new boolean[n+1][sum/2+1];
	    for(int i = 0;i<dp.length;i++){
	        for(int j = 0;j<dp[0].length;j++){
	            if(i==0 && j==0){
	                dp[i][j] = true;
	            }else if(j==0){
	                dp[i][j] = true;
	            }else if(i==0){
	                dp[i][j] =false;
	            }else{
	                if(dp[i-1][j]==true){
	                    dp[i][j] = true;
	                }
	                if(arr[i-1]<=j && dp[i-1][j-arr[i-1]]==true){
	                    dp[i][j] = true;
	                }
	            }
	           // System.out.print(dp[i][j]+" ");
	        }
	       // System.out.println();
	    }
	    int diff = Integer.MAX_VALUE;
	    for(int i = 0;i<dp[0].length;i++){
	        if(dp[n][i]==true)
	        diff = Math.min(diff,Math.abs(sum-(2*i)));
	    }
	    return diff;
	} 
}
/*Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference


Example 1:

Input: N = 4, arr[] = {1, 6, 11, 5} 
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   
Example 2:
Input: N = 2, arr[] = {1, 4}
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4
*/
