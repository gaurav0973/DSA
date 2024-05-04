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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Node{
    int row;
    int col;
    int steps;
    Node(int r, int c, int s){
        this.row = r;
        this.col = c;
        this.steps = s;
    }
}

class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];
        bfs(grid, visited, ans);
        return ans;
    }

    public void bfs(int[][] grid, boolean[][] visited, int[][] ans) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        while (q.size()>0) {
            
            Node rem = q.poll();
            int row = rem.row;
            int col = rem.col;
            int step = rem.steps;
            ans[row][col] = step;
            // up
            if (isValidLocation(row - 1, col, n, m) && grid[row - 1][col] == 0 && !visited[row - 1][col]) {
                q.add(new Node(row - 1, col, step + 1));
                visited[row - 1][col] = true;
            }
            // right
            if (isValidLocation(row, col + 1, n, m) && grid[row][col + 1] == 0 && !visited[row][col + 1]) {
                q.add(new Node(row, col + 1, step + 1));
                visited[row][col + 1] = true;
            }
            // down
            if (isValidLocation(row + 1, col, n, m) && grid[row + 1][col] == 0 && !visited[row + 1][col]) {
                q.add(new Node(row + 1, col, step + 1));
                visited[row + 1][col] = true;
            }
            // left
            if (isValidLocation(row, col - 1, n, m) && grid[row][col - 1] == 0 && !visited[row][col - 1]) {
                q.add(new Node(row, col - 1, step + 1));
                visited[row][col - 1] = true;
            }
        }
    }

    public boolean isValidLocation(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}