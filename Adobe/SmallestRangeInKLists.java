// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}
// } Driver Code Ends


class Solution
{
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    //add your code here
	    PriorityQueue<pair> pq = new PriorityQueue<>();
	    int[] ans = new int[2];
	    ans[0] = 0;
	    ans[1] = 100000;
	    int[] ind = new int[k];
	    int max = 0;
	    for(int i = 0;i<k;i++){
	        max = Math.max(max,arr[i][0]);
	        pq.add(new pair(arr[i][0],0,i));
	    }
	    
	    if(ans[1]-ans[0]>max-pq.peek().val){
	            ans[1] = max;
	            ans[0] = pq.peek().val;
	        }
	        
	    for(int i = 0;i<n*k - k;i++){
	        pair rem = pq.poll();
	        if(ans[1]-ans[0]>max-rem.val){
	            ans[1] = max;
	            ans[0] = rem.val;
	        }
	        if(rem.val_ind+1==n){
	            return ans;
	        }
	        pq.add(new pair(arr[rem.arr_ind][rem.val_ind+1],rem.val_ind+1,rem.arr_ind));
	        max = Math.max(max,arr[rem.arr_ind][rem.val_ind+1]);
	    }
	    return ans;
	}
	static class pair implements Comparable<pair>{
	    int val;
	    int val_ind;
	    int arr_ind;
	    pair(int val,int val_ind,int arr_ind){
	        this.val = val;
	        this.val_ind = val_ind;
	        this.arr_ind = arr_ind;
	    }
	    public int compareTo(pair p){
	        if(p.val==this.val){
	            return 0;
	        }else if(this.val>p.val){
	            return 1;
	        }else{
	            return -1;
	        }
	    }
	}
}
/*
Given K sorted lists of integers, KSortedArray[] of size N each. The task is to find the smallest range that includes at least one element from each of the K lists. If more than one such range's are found, return the first such range found.

Example 1:

Input:
N = 5, K = 3
KSortedArray[][] = {{1 3 5 7 9},
                    {0 2 4 6 8},
                    {2 3 5 7 11}}
Output: 1 2
Explanation: K = 3
A:[1 3 5 7 9]
B:[0 2 4 6 8]
C:[2 3 5 7 11]
Smallest range is formed by number 1
present in first list and 2 is present
in both 2nd and 3rd list.
Example 2:

Input:
N = 4, K = 3
KSortedArray[][] = {{1 2 3 4},
                    {5 6 7 8},
                    {9 10 11 12}}
Output: 4 9*/