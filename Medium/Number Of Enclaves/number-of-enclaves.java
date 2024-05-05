//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int first;
    int second;
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        return bfs(grid, visited);
    }
    int bfs(int[][] grid, boolean[][] visited)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        //columns
        for(int i=0; i<n; i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                q.add(new Pair(i,0));
                visited[i][0] = true;
            }
            if(grid[i][m-1] == 1 && !visited[i][m-1]){
                q.add(new Pair(i,m-1));
                visited[i][m-1] = true;
            }
        }
        //rows
        for(int j=0; j<m; j++){
            if(grid[0][j] == 1 && !visited[0][j]){
                q.add(new Pair(0,j));
                visited[0][j] = true;
            }
            if(grid[n-1][j] == 1 && !visited[n-1][j]){ 
                q.add(new Pair(n-1,j));
                visited[n-1][j] = true;
            }
        }
        
        //leevel order traversal
        while(q.size()>0)
        {
            Pair rem = q.poll();
            int row = rem.first;
            int col = rem.second;
            // up
            if (isValidLocation(row - 1, col, n, m) && grid[row - 1][col] == 1 && !visited[row - 1][col]) {
                q.add(new Pair(row - 1, col));
                visited[row - 1][col] = true;
            }
            // right
            if (isValidLocation(row, col + 1, n, m) && grid[row][col + 1] == 1 && !visited[row][col + 1]) {
                q.add(new Pair(row, col + 1));
                visited[row][col + 1] = true;
            }
            // down
            if (isValidLocation(row + 1, col, n, m) && grid[row + 1][col] == 1 && !visited[row + 1][col]) {
                q.add(new Pair(row + 1, col));
                visited[row + 1][col] = true;
            }
            // left
            if (isValidLocation(row, col - 1, n, m) && grid[row][col - 1] == 1 && !visited[row][col - 1]) {
                q.add(new Pair(row, col - 1));
                visited[row][col - 1] = true;
            }
        }
        
        //counting the 1 which are not visited
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && !visited[i][j])
                    count++;
            }
        }
        return count;
        
    }
    boolean isValidLocation(int i, int j, int n, int m) { 
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}