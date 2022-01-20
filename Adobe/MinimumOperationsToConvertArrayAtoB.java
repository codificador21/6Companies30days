// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);
                
            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(S2[i]);

            Solution ob = new Solution();
            System.out.println(ob.minInsAndDel(A,B,N,M));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minInsAndDel(int[] A, int[] B, int n, int m) {
        // code here
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(binarysearch(B,0,m-1,A[i])){
                arr.add(A[i]);
            }
        }
        if(arr.size()==0){
            return n+m;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr.get(0));
        for(int i = 1;i<arr.size();i++){
            if(arr.get(i)>list.get(list.size()-1)){
                list.add(arr.get(i));
            }else{
                int rep = binarysearch(list,arr.get(i));
                list.set(rep,arr.get(i));
            }
        }
        // System.out.println(arr);
        // System.out.println(list.size());
        return n+m-(2*list.size());
    }
    static int binarysearch(ArrayList<Integer>list,int num){
        int l = 0,r = list.size();
        while(l<r){
            int mid = (l+r)/2;
            if(num<=list.get(mid)){
                r = mid;
            }else{
                l=mid+1;
            }
            
        }
        if (l < list.size() && list.get(l) < num) {
            l++;
        }
        return l;
    }
    static boolean binarysearch(int[] A,int l,int r,int num){
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid]<num){
                l = mid+1;
            }else if(A[mid]>num){
                r = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
};
/*Given two Arrays A[] and B[] of length N and M respectively. Find the minimum number of insertions and deletions on the array A[], required to make both the arrays identical.
Note: Array B[] is sorted and all its elements are distinct, operations can be performed at any index not necessarily at end.

 

Example 1:

Input:
N = 5, M = 3
A[] = {1, 2, 5, 3, 1}
B[] = {1, 3, 5}
Output:
4
Explanation:
We need to delete 2 and replace it with 3.
This costs 2 steps. Further, we will have to
delete the last two elements from A to
obtain an identical array to B. Overall, it
results in 4 steps.
Example 2:
Input:
N = 2, M = 2
A[] = {1, 4}
B[] = {1, 4}
Output :
0
Explanation:
Both the Arrays are already identical.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minInsAndDel() which takes two integers N and M, and two arrays A of size N and B of size M respectively as input and returns the minimum insertions and deletions required.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)*/