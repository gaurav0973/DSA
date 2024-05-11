//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int first, second, third; 
    Tuple(int first, int second, int third) {
        this.first = first; 
        this.second = second;
        this.third = third; 
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        
        //1. creation of the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2])); 
        }
        
        //2. Queue and dist array initialisation
        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9); 
        }
        
        //3 adding soursee node in the queue and mark it as 0
        q.add(new Tuple(0,src,0));
        dist[src] = 0;
        
        //4.Apply level order traversal in Queue
        while(q.size() >0)
        {
            Tuple rem = q.remove();
            int stops = rem.first;
            int node = rem.second;
            int distance = rem.third;
            
            //moving to the nbrs
            for(Pair nbr : adj.get(node))
            {
                int nbrNode = nbr.first;
                int edgeWt = nbr.second;
                int d = distance + edgeWt;
                
                if(stops <= k && d < dist[nbrNode]) {
                    dist[nbrNode] = d;
                    q.add(new Tuple(stops + 1, nbrNode, d));
                }
            }
        }
        
        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst];
        
    }
}