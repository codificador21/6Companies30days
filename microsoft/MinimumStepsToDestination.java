// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minSteps(int D){
        // code here
        
        for(int i=1;i<10000;i++){
            int num = sum(i);
            if(num>=D && (num-D)%2==0){
                return i;
            }
        }
        return 0;
    }
    static int sum(int n){
        return (n*(n+1))/2;
    }
}
/*
Given an infinite number line. You start at 0 and can go either to the left or to the right. The condition is that in the ith move, youmust take i steps. Given a destination D , find the minimum number of steps required to reach that destination.

Example 1:

Input: D = 2
Output: 3
Explaination: The steps takn are +1, -2 and +3.
Example 2:

Input: D = 10
Output: 4
Explaination: The steps are +1, +2, +3 and +4.*/