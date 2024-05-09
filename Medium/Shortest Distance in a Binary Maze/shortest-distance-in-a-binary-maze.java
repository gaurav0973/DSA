//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Tuple { 
    int first, second, third; 
    Tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;
        
        //so
        if(source[0] == destination[0] && source[1] == destination[1])
            return 0;
        
        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0, source[0], source[1]));
        
        int delRow[] = {-1, 0, 1, 0}; 
        int delCol[] = {0, 1, 0, -1};
        
        while(q.size() > 0)
        {
            Tuple rem = q.remove();
            int distance = rem.first;
            int row = rem.second;
            int col = rem.third;
            
            for(int i=0; i<4; i++)
            {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                
                int d = distance + 1;
                if(isValidLocation(newRow, newCol, n, m) && grid[newRow][newCol] == 1 && d < dist[newRow][newCol]){
                    dist[newRow][newCol] = d;
                    
                    if(newRow == destination[0] && newCol == destination[1]){
                        return d;
                    }
                    q.add(new Tuple(d, newRow, newCol));
                }
            }
        }
        return -1;
        
        
    }
    public boolean isValidLocation(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
