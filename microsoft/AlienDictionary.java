// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return 1;
                        else
                            return 0;
                    }
                
                    if(index1 < index2)
                        return 1;
                    else
                        return 0;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        HashMap<Character,HashSet<Character>> map = new HashMap<>();
        HashMap<Character,Integer> indegree = new HashMap<>();
        
        for(String str:dict){
            for(char ch:str.toCharArray()){
                indegree.put(ch,0);
            }
        }
        for(int i = 0;i<N-1;i++){
            String curr = dict[i];
            String next = dict[i+1];
            boolean flag = false;
            int len = Math.min(curr.length(),next.length());
            for(int j = 0;j<len;j++){
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                if(ch1!=ch2){
                    HashSet<Character> set = new HashSet<>();
                    if(map.containsKey(ch1)==true){
                        set = map.get(ch1);
                        if(set.contains(ch2)==false){
                            set.add(ch2);
                            map.put(ch1,set);
                            indegree.put(ch2,indegree.get(ch2)+1);
                        }
                    }else{
                        set.add(ch2);
                        indegree.put(ch2,indegree.get(ch2)+1);
                        map.put(ch1,set);
                    }
                    flag = true;
                    break;
                }
            }
            if(flag == false && curr.length()>next.length()){
                return "";
            }
        }
        
        Queue<Character> que = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch:indegree.keySet()){
            if(indegree.get(ch)==0){
                que.add(ch);
            }
        }
        int count = 0;
        while(que.size()>0){
            char rem = que.remove();
            sb.append(rem);
            count++;
            if(map.containsKey(rem)){
                HashSet<Character> nbrs = map.get(rem);
                for(char nbr:nbrs){
                    indegree.put(nbr,indegree.get(nbr)-1);
                    if(indegree.get(nbr)==0){
                        que.add(nbr);
                    }
                }
            }
        }
        if(count == indegree.size()){
            return sb.toString();
        }else{
            return "";
        }
    }
}
/*Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 

Example 1:

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.*/