class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<edge> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.w, a.w); // larger weight(success probability) go first 
        });
        boolean [] vis = new boolean[n];
        double [] dis = new double[n];
        List<edge> [] adj = new List[n];
        for (int i = 0; i<n; i++) adj[i] = new ArrayList<>();
        int idx = 0;
        for (int [] nxt : edges) {
            adj[nxt[0]].add(new edge(nxt[1], succProb[idx]));
            adj[nxt[1]].add(new edge(nxt[0], succProb[idx]));
            idx++;
        }
        pq.add(new edge(start, 1.0));
        while (pq.size() > 0) {
            edge cur = pq.poll();
            if (cur.w <= dis[cur.dest]) continue;
            dis[cur.dest] = cur.w;
            vis[cur.dest] = true;
            for (edge nxt : adj[cur.dest]) {
                if (vis[nxt.dest]) continue;
                pq.add(new edge(nxt.dest, dis[cur.dest] * nxt.w));
            }
        }
        return dis[end];
    }
    public class edge {
        int dest;
        double w;
        edge(int u, double succ) { dest = u; w = succ; }
    }
}
/*You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 ###DIJKSTRA ALGO###

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000
Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.*/