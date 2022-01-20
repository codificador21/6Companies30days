// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.kvowelwords(N,K);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public int kvowelwords(int N,int K){
        // code here
        int i,j;
        long MOD = 1000000007;
        long dp[][] = new long[N+1][K+1];
        long sum=1;
        for(i=1;i<=N;i++)
        {
            dp[i][0]=sum*21l;
            dp[i][0]%=MOD;
            sum=dp[i][0];
            for(j=1;j<=K;j++)
            {             
                if(j>i)
                dp[i][j]=0l;
                else if(j==i)
                dp[i][j]=power(5l,i,MOD);
                else
                dp[i][j]=dp[i-1][j-1]*5l;
                dp[i][j]%=MOD;
                sum+=dp[i][j];
                sum%=MOD;
            }
        }
        return (int)sum;
    }


    long power(long x, long y, long p)  
    {  
        long res = 1l;     
        x = x % p;   
        if (x == 0) return 0; 
        
        while (y > 0)  
        {  
            if (y %2 == 1)  
                res = (res*x) % p;  
            y = y>>1; 
            x = (x*x) % p;  
        }  
        return res;  
    }  
}
/*Find the number of unique words consisting of lowercase alphabets only of length N that can be formed with at-most K contiguous vowels. 


Example 1:

Input:
N = 1
K = 0
Output:
21
Explanation:
All 21 consonants.
Example 2:

Input:
N = 1
K = 1
Output:
26
Explanation:
All the english alphabets including
vowels and consonants.*/
