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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        // code here
        int n = str.length();
        int []dp = new int[n];
        if(str.charAt(0)=='0'){
            dp[0] = 0;
        }else{
            dp[0] = 1;
        }
        // System.out.print(dp[0]+" ");
        for(int i = 1;i<n;i++){
            if(str.charAt(i-1)=='0' && str.charAt(i)=='0'){
                dp[i] = 0;
            }else if(str.charAt(i-1)!='0' && str.charAt(i)=='0'){
                if(str.charAt(i-1)=='1' || str.charAt(i-1)=='2'){
                    dp[i] = i>=2?dp[i-2]:1;
                }else{
                    dp[i]=0;
                }
            }else if(str.charAt(i-1)=='0'&& str.charAt(i)!='0'){
                dp[i] = dp[i-1];
            }else{
                int num = Integer.parseInt(str.substring(i-1,i+1));
                if(num>26){
                    dp[i] = dp[i-1];
                }else{
                    dp[i] = dp[i-1] + (i>=2?dp[i-2]:1);
                }
            }
            dp[i]=dp[i]%1000000007;
            // System.out.print(dp[i]+" ");
        }
        
        return dp[n-1];
    }
}
/*A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded, as the answer can be large return the answer modulo 109 + 7.
Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.

Example 1:

Input: str = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(123),
"LC"(12 3) and "AW"(1 23).*/