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
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String matrixChainOrder(int mat[], int n){
        // code here
        Pair[][] dp = new Pair[n][n];
        if(mat.length == 2)
		  return "A";
        return matMult(mat, dp, 0, n-1).format;
    }
    public static Pair matMult(int[] mat, Pair[][] dp, int l, int r){
        
        if(r-l == 2){
            char mat1 = (char)(65+l);
            char mat2 = (char)(65+r-1);
            String format = getFormat(Character.toString(mat1), Character.toString(mat2));
            return new Pair(mat[l]*mat[l+1]*mat[r], format);
        }
        
        if(dp[l][r] != null){
            return dp[l][r];
        }
        
        int min = Integer.MAX_VALUE, cost;
        String format = "";
        String left = Character.toString((char)(l+65)), mat1;
        String right = Character.toString((char)(r+65-1)), mat2;
        for(int m=l+1; m<r; m++){
            
            mat1=left; mat2=right; cost=0;
            
            if(m-l > 1){
                Pair p = matMult(mat, dp, l, m);
                cost += p.cost;
                mat1 = p.format;
            }
            if(r-m > 1){
                Pair p = matMult(mat, dp, m, r);
                cost += p.cost;
                mat2 = p.format;
            }
            
            cost += mat[l] * mat[m] * mat[r];
            if(cost < min){
                min = cost;
                format = getFormat(mat1, mat2);
            }
        }
        
        
        return dp[l][r] = new Pair(min, format);
    }
    public static String getFormat(String mat1, String mat2){
        return "(" + mat1 + mat2 + ")";
    }
    static class Pair{
        int cost;
        String format;
        
        Pair(int cost, String format){
            this.cost = cost;
            this.format = format;
        }
    }
    
}
/*Given an array p[] of length n used to denote the dimensions of a series of matrices such that dimension of i'th matrix is p[i] * p[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply these matrices together. 
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications such that you need to perform minimum number of multiplications. There are many options to multiply a chain of matrices because matrix multiplication is associative i.e. no matter how one parenthesize the product, the result will be the same.


Example 1:

Input: 
n = 5
p[] = {1, 2, 3, 4, 5}
Output: (((AB)C)D)
Explaination: The total number of 
multiplications are (1*2*3) + (1*3*4) 
+ (1*4*5) = 6 + 12 + 20 = 38.
 

Example 2:

Input: 
n = 3
p = {3, 3, 3}
Output: (AB)
Explaination: The total number of 
multiplications are (3*3*3) = 27.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function matrixChainOrder() which takes n and p[] as input parameters and returns the string with the proper order of parenthesis for n-1 matrices. Use uppercase alphabets to denote each matrix.


Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)


Constraints:
2 ≤ n ≤ 26 
1 ≤ p[i] ≤ 500 */