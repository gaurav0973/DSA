#User function Template for python3
import heapq
class Solution:
    
    #Function to find sum of weights of edges of the Minimum Spanning Tree.
    def spanningTree(self, V, adj):
        #code here
        # Priority queue: (weight, node)
        pq = []
        # Start with node 0, weight 0
        heapq.heappush(pq, (0, 0))
    
        # isMST array to keep track of included nodes in MST
        isMST = [False] * V
    
        cost = 0
        while len(pq) > 0:
            top_element = heapq.heappop(pq)
            wt = top_element[0]
            node = top_element[1]
        
            if not isMST[node]:
                isMST[node] = True
                cost += wt
            
                for neighbor in adj[node]:
                    nbr = neighbor[0]
                    nbr_wt = neighbor[1]
                    if not isMST[nbr]:
                        heapq.heappush(pq, (nbr_wt, nbr))
    
        return cost
#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

# Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases):
        V,E = map(int,input().strip().split())
        adj = [[] for i in range(V)]
        for i in range(E):
            u,v,w = map(int,input().strip().split())
            adj[u].append([v,w])
            adj[v].append([u,w])
        ob = Solution()
        
        print(ob.spanningTree(V,adj))
# } Driver Code Ends