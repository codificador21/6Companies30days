// { Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	    // Your code here
	    for(int i = 0;i<str.length();i++){
	        if(i==0 && str.charAt(i)=='-')
	            continue;
	        if(str.charAt(i)<48 || str.charAt(i)>57){
	            return -1;
	        }
	    }
    	return Integer.parseInt(str);
    }
}
/*Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.

Note: You are not allowed to use inbuilt function.

Example 1:

Input:
str = 123
Output: 123
Example 2:

Input:
str = 21a
Output: -1
Explanation: Output is -1 as all
characters are not digit only.*/