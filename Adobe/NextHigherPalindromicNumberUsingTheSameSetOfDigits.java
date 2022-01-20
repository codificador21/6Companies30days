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
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        }
            
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String nextPalin(String N) 
    { 
        //complete the function here
        if(N.length()<4){
            return "-1";
        }
        int ind1 = -1;
        for(int i = 1;i<N.length()/2;i++){
            int ch1 = N.charAt(i-1)-'0';
            int ch2 = N.charAt(i)-'0';
            if(ch2>ch1){
                ind1 = i-1;
            }
        }
        if(ind1==-1){
            return "-1";
        }
        int ind2 = 0;
        for(int i = N.length()/2-1;i>=ind1+1;i--){
            int ch1 = N.charAt(i)-'0';
            int ch2 = N.charAt(ind1)-'0';
            if(ch1>ch2){
                ind2 = i;
                break;
            }
        }
        char[] charr = N.toCharArray();
        // System.out.print
        
        char temp = charr[ind2];
        charr[ind2] = charr[ind1];
        charr[ind1] = temp;
        reverse(charr,ind1+1,N.length()/2-1);
        
        ind1 = N.length()-ind1-1;
        ind2 = N.length()-ind2-1;
        
        temp = charr[ind2];
        charr[ind2] = charr[ind1];
        charr[ind1] = temp;
        reverse(charr,N.length()%2==0?N.length()/2:N.length()/2+1,ind1-1);
        
        StringBuilder str = new StringBuilder();
        for(char ch:charr){
            str.append(ch);
        }
        return str.toString();
    }
    private void reverse(char[] charr, int i, int j) {
    while (i < j) {
        char temp = charr[i];
        charr[i] = charr[j];
        charr[j] = temp;
        i++;
        j--;
    }
}
}
/*Given a palindromic number N in the form of string. The task is to find the smallest palindromic number greater than N using the same set of digits as in N.

Example 1:

Input: 
N = "35453"
Output: 
53435
Explanation: Next higher palindromic 
number is 53435.
Example 2:

Input: N = "33"
Output: -1
Explanation: Next higher palindromic number 
does not exist.*/