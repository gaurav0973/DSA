//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!visited[i]){
                if(checkForCycle(i,adj, visited))
                    return true;
            }
                
        }
        return false;
    }
    public boolean checkForCycle(int source,ArrayList<ArrayList<Integer>> adj,boolean[] visited) // corrected here
    {
        visited[source] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source, -1));
        
        while(q.size()>0)
        {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            
            for(int neighbour : adj.get(node))
            {
                if(!visited[neighbour])
                {
                    visited[neighbour] = true;
                    q.add(new Pair(neighbour,node));
                }
                else if(parent != neighbour)
                    return true;
            }
        }
        return false;
    }
}
