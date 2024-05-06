//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        boolean[] inRecPath = new boolean[V];
        
        
        //for the components
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,inRecPath))
                    return true;
            }
        }
        
        return false;
    }
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] inRecPath)
    {
        visited[node] = true;
        inRecPath[node] = true;
        
        for(int nbr : adj.get(node)){
            //if nbr node is not visited
            if(!visited[nbr]){
                if(dfs(nbr,adj,visited,inRecPath))
                    return true;
            }
            //nbr is visited and in the path
            else if(inRecPath[nbr]){
                return true;
            }
        }
        
        inRecPath[node] = false;
        return false;
        
        
        
    }
}