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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends
class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        // Adding rotten oranges in the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.offer(new Pair(i, j));
            }
        }

        // Level order traversal
        int time = -1;
        while (q.size() > 0) {
            int levelElementCount = q.size();
            time++;
            for (int i = 1; i <= levelElementCount; i++) {
                Pair node = q.poll();
                int row = node.row;
                int col = node.col;
                // Upward
                if (isValidLocation(row - 1, col, n, m, grid) && grid[row - 1][col] == 1) {
                    q.offer(new Pair(row - 1, col));
                    grid[row - 1][col] = 2;
                }
                // Right
                if (isValidLocation(row, col + 1, n, m, grid) && grid[row][col + 1] == 1) {
                    q.offer(new Pair(row, col + 1));
                    grid[row][col + 1] = 2;
                }
                // Downwards
                if (isValidLocation(row + 1, col, n, m, grid) && grid[row + 1][col] == 1) {
                    q.offer(new Pair(row + 1, col));
                    grid[row + 1][col] = 2;
                }
                // Left
                if (isValidLocation(row, col - 1, n, m, grid) && grid[row][col - 1] == 1) {
                    q.offer(new Pair(row, col - 1));
                    grid[row][col - 1] = 2;
                }
            }
        }
        // If any fresh oranges are left then return -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return time < 0 ? 0 : time;

    }

    public boolean isValidLocation(int i, int j, int n, int m, int[][] grid) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
