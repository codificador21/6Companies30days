// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.height(N));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int height(int N){
        // code here
        return (-1+(int)(Math.sqrt(1+8*N)))/2;
    }
}
/*Given N dots that form a triangle such that ith line contains i number of dots.

    .
   . .
  . . .
 . . . .
Find the minimum hieght H of the triangle that can be formed using these N dots.

 

Example 1:

Input: N = 1
Output: 2
Explaination: The height will be 1. We 
need one dot to create first line. With 
the remaining one we cannot complete the 
second line.
 

Example 2:

Input: N = 10
Output: 4
Explaination: With 10 dots we can complete 
total four lines. The layers will have 1, 
2, 3 and 4 dots respectively.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function height() which takes N as input parameter and returns the height of the triangle that we can form using N dots.

 

Expected Time Comlpexity: O(1)
Expected Auxiliary Space: O(1)*/