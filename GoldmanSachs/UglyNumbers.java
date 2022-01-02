// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new Solution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class Solution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        long [] arr = new long[n];
        int p2 = 0,p3 = 0,p5 = 0;
        arr[0]=1;
        int idx = 1;
        while(idx!=n){
            long v2 = arr[p2]*2;
            long v3 = arr[p3]*3;
            long v5 = arr[p5]*5;
            
            long temp = Math.min(v2,Math.min(v3,v5));
            arr[idx++] = temp;
            if(temp==v2){
                p2++;
            }
            if(temp==v3){
                p3++;
            }
            if(temp==v5){
                p5++;
            }
        }
        
        return arr[n-1];
    }
}
//Q) Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
//1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. 
//By convention, 1 is included. Write a program to find Nth Ugly Number.