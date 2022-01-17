// { Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int arr[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> list = new ArrayList<>();
        int minrow = 0;
		int maxrow = r - 1;
		int mincol = 0;
		int maxcol = c - 1;
		int n = r*c;
		int cnt = 0;
		while (cnt < n) {
			for (int i = mincol; i <= maxcol && cnt < n; i++) {
				list.add(arr[minrow][i]);
				cnt++;
			}
			minrow++;
			for (int j = minrow; j <= maxrow && cnt < n; j++) {
				list.add(arr[j][maxcol]);
				cnt++;
			}
			maxcol--;
			for (int i = maxcol; i >= mincol && cnt < n; i--) {
				list.add(arr[maxrow][i]);
				cnt++;
			}
			maxrow--;
			for (int j = maxrow; j >= minrow && cnt < n; j--) {
				list.add(arr[j][mincol]);
				cnt++;
			}
			mincol++;

		}
		return list;
    }
}
/*Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

Example 2:

Input:
r = 3, c = 4  
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12}}
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.*/