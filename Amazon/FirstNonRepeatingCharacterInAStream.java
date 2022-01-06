// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        StringBuilder sb = new StringBuilder("");
        // sb.append('');
        int[] visited = new int[26];
        // ArrayList<Character> order = new ArrayList<>();
        char[] order = new char[26];
        int idx = 0;
        for(int i = 0;i<A.length();i++){
            char ch = A.charAt(i);
            if(visited[ch-'a']==0){
                // order.add(ch);
                order[idx++] = ch;
            }
            visited[ch-'a']++;
            boolean flag = false;
            for(int j = 0;j<26;j++){
                if(order[j]==0) break;
                char ch2= order[j];
                if(visited[ch2-'a']==1){
                    // ans+=ch2;
                    sb.append(ch2);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                // ans+="#";
                sb.append('#');
            }
        }
        return sb.toString();
    }
}
/*Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream. If there is no such character then append '#' to the answer.
 

Example 1:

Input: A = "aabc"
Output: "a#bb"
Explanation: For every character first non
repeating character is as follow-
"a" - first non-repeating character is 'a'
"aa" - no non-repeating character so '#'
"aab" - first non-repeating character is 'b'
"aabc" - first non-repeating character is 'b'*/