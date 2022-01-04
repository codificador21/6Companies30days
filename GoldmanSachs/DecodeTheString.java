// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        Stack<Integer> count = new Stack<>();
        Stack<String> st = new Stack<>();
        String res = "";
        int i = 0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int tot = 0;
                while(Character.isDigit(s.charAt(i))){
                    tot = 10*tot+ (s.charAt(i++)-'0');
                }
                count.push(tot);
            }else if(s.charAt(i)== '['){
                st.push(res);
                res = "";
                i++;
            }else if(s.charAt(i)== ']'){
                int num = count.pop();
                StringBuilder sb = new StringBuilder(st.pop());
                // sb = st.pop();
                for(int j = 1;j<=num;j++){
                    sb.append(res);
                }
                res = sb.toString();
                i++;
                
            }else{
                res = res+s.charAt(i++);
                
            }
            
        }
        return res;
    }
}
/*An encoded string (s) is given, the task is to decode it. The pattern in which the strings 
were encoded were as follows
original string: abbbababbbababbbab 
encoded string : 3[a3[b]1[ab]]

Example 1:

Input: s = 1[b]
Output: b
Explaination: 'b' is present only one time.
Example 2:

Input: s = 3[b2[ca]]
Output: bcacabcacabcaca
Explaination: 2[ca] means 'ca' is repeated 
twice which is 'caca' which concatenated with 
'b' becomes 'bcaca'. This string repeated 
thrice becomes the output.
*/