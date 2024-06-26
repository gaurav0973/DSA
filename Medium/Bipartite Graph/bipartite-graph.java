//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color,-1);
        
        //handling the component case
        for(int i=0; i<V; i++){
            //if not coversed
            if(color[i] == -1){
                if(dfs(i,0,adj,color)==false)
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node , int col, ArrayList<ArrayList<Integer>>adj, int[] color)
    {
        
        color[node] = col;
        
        //now lets go to the nbrs of the node
        for(int nbr : adj.get(node))
        {
            //if neighbour is not coloured then col it with opposite color
            if(color[nbr] == -1){
                if(!dfs(nbr,1-col,adj,color))
                    return false;
            }
            //if col of nbr is similar to the node return false
            else if(color[nbr] == col){
                return false;
            }
        }
        return true;
    }
}