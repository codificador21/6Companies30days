// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> list = new ArrayList();
        generate(list,"",0,0,n);
        return list;
    }
    public void generate(List<String> list,String str,int open,int close,int tot){
        if(str.length()==2*tot){
            list.add(str);
            return;
        }
        if(open<tot){
            generate(list,str+"(",open+1,close,tot);
        }
        if(close<open){
            generate(list,str+")",open,close+1,tot);
        }
    }
}
/*Given an integer N representing the number of pairs of parentheses, 
the task is to generate all combinations of well-formed(balanced) parentheses.


Example 1:

Input:
N = 3
Output:
((()))
(()())
(())()
()(())
()()()
Example 2:
Input:
N = 1
Output:
()*/