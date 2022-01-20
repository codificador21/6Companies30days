// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] arr, int n) {
        // code here
        HashMap<Integer,Integer>[]dp = new HashMap[n];
        if(n==1 || n==2){
            return n;
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            dp[i] = new HashMap<>();
            for(int j = i-1;j>=0;j--){
                int diff = arr[i]-arr[j];
                if(dp[j].containsKey(diff)){
                    dp[i].put(diff,dp[j].get(diff)+1);
                }else{
                    dp[i].put(diff,2);
                }
                max = Math.max(max,dp[i].get(diff));
            }
        }
        return max;
    }
}
/*Given an array called A[] of sorted integers having no duplicates, find the length of the Longest Arithmetic Progression (LLAP) in it.


Example 1:

Input:
N = 6
set[] = {1, 7, 10, 13, 14, 19}
Output: 4
Explanation: The longest arithmetic 
progression is {1, 7, 13, 19}.
Example 2:

Input:
N = 5
A[] = {2, 4, 6, 8, 10}
Output: 5
Explanation: The whole set is in AP.*/
