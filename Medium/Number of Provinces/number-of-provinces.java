//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        //converting adj-matrix into adjList
        ArrayList<ArrayList<Integer>> adjLst = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++){
            adjLst.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(adj.get(i).get(j) == 1) {
                    adjLst.get(i).add(j);
                    adjLst.get(j).add(i); // Add this line to add the reverse edge
                }
            }
        }
        
        
        boolean[] visited = new boolean[V];
        int count = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                count++;
                dfs(i, adjLst, visited);
            }
        }
        return count;
        
    }
    static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited)
    {
        //base case
        if(visited[node])
            return;
        
        visited[node] = true;
        //dfs work
        
        //lets talk about the neighbour
        for(int nbr : adjList.get(node)){
            if(!visited[nbr])
                dfs(nbr, adjList, visited);
        }
    }
}
