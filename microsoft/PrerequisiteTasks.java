// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] pre)
    {
        // Your Code goes here
        // boolean[] visited = new boolean[N];
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i = 0;i<N;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0;i<pre.length;i++){
            graph[pre[i][1]].add(pre[i][0]);
        }
        boolean[] visited = new boolean[N];
        boolean[] dfsvisited = new boolean[N];
        
        for(int i = 0;i<N;i++){
            if(visited[i]==false && iscyclic(graph,visited,dfsvisited,i)){
                return false;
            }
        }
        return true;
        
    }
    public boolean iscyclic(ArrayList<Integer>[] graph,boolean[] visited
    ,boolean[] dfsvisited,int n){
        
        if (visited[n])
            return false;
        
        visited[n] = dfsvisited[n] = true;
        for(Integer i:graph[n]){
            if(dfsvisited[i]==true || iscyclic(graph,visited,dfsvisited,i)){
                return true;
            }
        }
        
        return dfsvisited[n] = false;
        
    }
    
}
/*There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]
Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.


Example 1:

Input: 
N = 4, P = 3
prerequisites = {{1,0},{2,1},{3,2}}
Output:
Yes
Explanation:
To do task 1 you should have completed
task 0, and to do task 2 you should 
have finished task 1, and to do task 3 you 
should have finished task 2. So it is possible.
Example 2:

Input:
N = 2, P = 2
prerequisites = {{1,0},{0,1}}
Output:
No
Explanation:
To do task 1 you should have completed
task 0, and to do task 0 you should
have finished task 1. So it is impossible.*/