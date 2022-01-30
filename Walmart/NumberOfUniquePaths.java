// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
        static int NumberOfPath(int m, int n)
    {
        int count[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                count[i][j] = count[i - 1][j] + count[i][j - 1]; 
        }
        return count[m - 1][n - 1];
    }
}
/*Given a A X B matrix with your initial position at the top-left cell, find the number of possible unique paths to reach the bottom-right cell of the matrix from the initial position.

Note: Possible moves can be either down or right at any point in time, i.e., we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].

Example 1:

Input:
A = 2, B = 2
Output: 2
Explanation: There are only two unique
paths to reach the end of the matrix of
size two from the starting cell of the
matrix.
Example 2:

Input:
A = 3, B = 4
Output: 10
Explanation: There are only 10 unique
paths to reach the end of the matrix of
size two from the starting cell of the
matrix.
Your Task:
Complete NumberOfPath() function which takes 2 arguments(A and B) and returns the number of unique paths from top-left to the bottom-right cell.

Expected Time Complexity: O(A*B).
Expected Auxiliary Space: O(A*B).

Constraints:
1 ≤ A ≤ 15
1 ≤ B ≤ 15*/