// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

 class Solution{
    public String amendSentence(String s){
        //code here
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i)>=65 && s.charAt(i)<=90){
                if(i>0){
                    str.append(" ");
                }
                str.append(Character.toLowerCase(s.charAt(i))+"");
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
/*Given a string which is basically a sentence without spaces between words. However the first letter of every word is in uppercase. You need to print this sentence after following amendments:
(i) Put a single space between these words
(ii) Convert the uppercase letters to lowercase.
Note: The first character of the string can be both uppercase/lowercase.

Example 1:

Input:
s = "BruceWayneIsBatman"
Output: bruce wayne is batman
Explanation: The words in the string are
"Bruce", "Wayne", "Is", "Batman".

​Example 2:

Input: 
s = "You"
Output: you
Explanation: The only word in the string
is "You".*/

