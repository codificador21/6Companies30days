import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        List<List<String>> ans = new ArrayList<List<String>>();
        int n = string_list.length;
        String[] sarr = new String[n];
        for(int i = 0;i<n;i++){
            char[] arr = string_list[i].toCharArray();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for(char ch: arr){
                sb.append(ch);
            }
            // System.out.println();
            sarr[i] = sb.toString();
            // System.out.print(sarr[i]+" ");
        }
        
        HashMap<String,Integer> map = new HashMap<>();
        int ind = 0;
        for(int i = 0;i<n;i++){
            List<String> list = new ArrayList<>();
            if(!map.containsKey(sarr[i])){
                map.put(sarr[i],ind);
                ans.add(ind++,list);
            }
            int j = map.get(sarr[i]);
            ans.get(j).add(string_list[i]);
        }
        
        return ans;
    }
}