// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        boolean[] visited = new boolean[V];
        
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        
        DFS(adj,c,visited);
        
        adj.get(c).add(d);
        adj.get(d).add(c);
        
        if(visited[d]==false){
            return 1;
        }
        return 0;
        
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj, int v, boolean visited[]) 
    {
        visited[v] = true;
        for (int i = 0; i < adj.get(v).size(); ++i)
            if (!visited[adj.get(v).get(i)])
                DFS(adj, adj.get(v).get(i), visited);
    }
}
/*Given a Graph of V vertices and E edges and another edge(c - d), the task is to find if the given edge is a Bridge. i.e., removing the edge disconnects the graph.

 

Example 1:

Input:

c = 1, d = 2
Output:
1
Explanation:
From the graph, we can clearly see that
blocking the edge 1-2 will result in 
disconnection of the graph. So, it is 
a Bridge and thus the Output 1.

Example 2:

Input:

c = 0, d = 2
Output:
0
Explanation:

blocking the edge between nodes 0 and 2
won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge
Edges in the graph are marked with a blue
line in the above image.*/