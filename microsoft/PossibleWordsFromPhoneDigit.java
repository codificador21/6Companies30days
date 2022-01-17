// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        String str = "";
        for(int i = 0;i<N;i++){
            str+=a[i];
        }
        ArrayList<String> list = getKPC(str);
        return list;
    }
    public static String getCode(char ch) {
		if (ch == '2')
			return "abc";
		else if (ch == '3')
			return "def";
		else if (ch == '4')
			return "ghi";
		else if (ch == '5')
			return "jkl";
		else if (ch == '6')
			return "mno";
		else if (ch == '7')
			return "pqrs";
		else if (ch == '8')
			return "tuv";
		else if (ch == '9')
			return "wxyz";
		else
			return "";
	}
	public static ArrayList <String> getKPC(String str) {
        if(str.length()==0){
            ArrayList<String> bl = new ArrayList<String>();
            bl.add("");
            return bl;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rl = getKPC(ros);
        ArrayList<String> ml = new ArrayList<>();
        String s = getCode(ch);
        for(int i=0;i<s.length();i++){
           for(String val:rl)
            ml.add(s.charAt(i)+val);
        }
       return ml; 
    }
}
/*Given a keypad as shown in the diagram, and an N digit number which is represented by array a[ ], the task is to list all words which are possible by pressing these numbers.


Example 1:

Input: N = 3, a[] = {2, 3, 4}
Output:
adg adh adi aeg aeh aei afg afh afi 
bdg bdh bdi beg beh bei bfg bfh bfi 
cdg cdh cdi ceg ceh cei cfg cfh cfi 
Explanation: When we press 2,3,4 then 
adg, adh, adi, ... cfi are the list of 
possible words.
Example 2:

Input: N = 3, a[] = {3, 4, 5}
Output:
dgj dgk dgl dhj dhk dhl dij dik dil 
egj egk egl ehj ehk ehl eij eik eil 
fgj fgk fgl fhj fhk fhl fij fik fil
Explanation: When we press 3,4,5 then 
dgj, dgk, dgl, ... fil are the list of 
possible words.*/


