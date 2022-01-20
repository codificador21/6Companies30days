// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int l = 0, r = 0,sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(r<n){
            
            if(sum+arr[r] == s){
                list.add(l+1);
                list.add(r+1);
                return list;
            }else if(sum+arr[r]<s){
                sum+=arr[r];
                r++;
            }else{
                sum-=arr[l];
                l++;
                
            }
        }
        if(list.size()==0) list.add(-1);
        return list;
    }
}
/*Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.

 

Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.
 

Example 2:

Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.*/