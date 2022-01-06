class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[]inc = new int[n];
        inc[0] = 1;
        for(int i = 1;i<n;i++){
            if(arr[i]>arr[i-1]){
                inc[i] = inc[i-1]+1;
            }else{
                inc[i]= 1;
            }
        }
        int[] dec = new int[n];
        dec[n-1] = 1;
        for(int i = n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                dec[i] = dec[i+1]+1;
            }else{
                dec[i] = 1;
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            if(dec[i]>1 && inc[i]>1)
            max = Math.max(max,dec[i]+inc[i]-1);
        }
        return max;
    }
}
/*You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

 

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.*/