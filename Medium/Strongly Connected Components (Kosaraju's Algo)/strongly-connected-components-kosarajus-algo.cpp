//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
	public:
	//Function to find number of strongly connected components in the graph.
    int kosaraju(int V, vector<vector<int>>& adj)
    {
        //1.sort all the edges according to there finishing time
        // apply dfs and store the finisherd dfs in a stack
        vector<int> visitedSort(V,0);
        stack<int> st;
        for(int i=0; i<V; i++){
            if(!visitedSort[i])
                dfsForSort(i,adj, visitedSort, st);
        }
        
        //2. reverse(transpose) the edges
        vector<vector<int>> adjT(V);
        for(int i=0; i<V; i++){
            for(auto nbr : adj[i]){
                //i->nbr
                //nbr->i
                adjT[nbr].push_back(i);
                
            }
        }
        
        
        //3.apply dfs on the reversed edges and count the scc
        int scc = 0;
        vector<int> visited(V,0);
        while (!st.empty()) {
            int node = st.top();
            st.pop();
            if (!visited[node]) {
                scc++;
                dfs(node, adjT, visited);
            }
        }
        return scc;
    }
    
    
    // dfs with soting the vertex accorfing to there fnish time 
    void dfsForSort(int node, vector<vector<int>>& adj,vector<int>& visitedSort,stack<int>& st)
    {
        visitedSort[node] = 1;
        
        for(auto nbr : adj[node]){
            if(!visitedSort[nbr]){
                dfsForSort(nbr, adj, visitedSort, st);
            }
        }
        
        st.push(node);
    }
    
    //simpe dfs 
    void dfs(int node, vector<vector<int>>& adjT,vector<int>& visited)
    {
        visited[node] = 1;
        
        for(auto nbr : adjT[node]){
            if(!visited[nbr]){
                dfs(nbr, adjT, visited);
            }
        }
        
    }
};

//{ Driver Code Starts.


int main()
{
    
    int t;
    cin >> t;
    while(t--)
    {
    	int V, E;
    	cin >> V >> E;

    	vector<vector<int>> adj(V);

    	for(int i = 0; i < E; i++)
    	{
    		int u, v;
    		cin >> u >> v;
    		adj[u].push_back(v);
    	}

    	Solution obj;
    	cout << obj.kosaraju(V, adj) << "\n";
    }

    return 0;
}


// } Driver Code Ends