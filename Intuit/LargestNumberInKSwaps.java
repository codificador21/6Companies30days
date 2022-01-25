// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}// } Driver Code Ends




class Solution
{
    //Function to find the largest number after k swaps.
    static String max;
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            max = str;
            findmax(str.toCharArray(), k);
            return max;
        }
    public static void findmax(char[] str,int k){
        if(k==0){
            return;
        }
        for(int i = 0;i<str.length-1;i++){
            for(int j = i+1;j<str.length;j++){
                if(str[i]<str[j]){
                    char[] sw = swap(str,i,j);
                    if (String.valueOf(str).compareTo(max) > 0)
                    max = String.valueOf(str);
                    findmax(sw,k-1);
                    sw = swap(str,i,j);
                }
            }
        }
    }
    public static char[] swap(char[] arr,int i,int j){
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
        return arr;
    }
}/*
Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of str at most K times.


Example 1:

Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
Example 2:

Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input
3435335 to 5543333, swapping 3 
with 5, 4 with 5 and finally 3 with 4 

Your task:
You don't have to read input or print anything. Your task is to complete the function findMaximumNum() which takes the string and an integer as input and returns a string containing the largest number formed by perfoming the swap operation at most k times.


Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ |str| ≤ 30
1 ≤ K ≤ 10*/