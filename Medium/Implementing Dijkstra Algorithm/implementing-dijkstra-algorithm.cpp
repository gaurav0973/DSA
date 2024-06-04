//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        
        vector<int> explored(V,0);
        vector<int> dist(V, 1e9);
        dist[S] = 0;
        
        
        for(int k = 0; k<V; k++){
            //select the node which is not explored yet ad its distance value is minimum
            int node = -1;
            int value = 1e9;
            for(int i=0; i<V; i++){
                if(!explored[i] && value > dist[i]){
                    node = i;
                    value = dist[i];
                }
            }
            explored[node] = 1;
            
            //relax the edges
            for(int j=0; j< adj[node].size() ; j++)
            {
                int nbr = adj[node][j][0];
                int wt = adj[node][j][1];
                if(!explored[nbr] && (dist[node] + wt < dist[nbr]))
                {
                    dist[nbr] = dist[node] + wt;
                }
            }
        }
        
        return dist;
     
     
    }
};


//{ Driver Code Starts.


int main()
{
    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;
        vector<vector<int>> adj[V];
        int i=0;
        while (i++<E) {
            int u, v, w;
            cin >> u >> v >> w;
            vector<int> t1,t2;
            t1.push_back(v);
            t1.push_back(w);
            adj[u].push_back(t1);
            t2.push_back(u);
            t2.push_back(w);
            adj[v].push_back(t2);
        }
        int S;
        cin>>S;
        
        Solution obj;
    	vector<int> res = obj.dijkstra(V, adj, S);
    	
    	for(int i=0; i<V; i++)
    	    cout<<res[i]<<" ";
    	cout<<endl;
    }

    return 0;
}


// } Driver Code Ends