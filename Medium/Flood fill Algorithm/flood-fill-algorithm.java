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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        
        int originalColor = image[sr][sc];
        dfs(sr,sc,newColor,originalColor,image,visited);
        return image;
    }
    public void dfs(int i, int j, int k,int originalColor, int[][] image, boolean[][] visited)
    {
        int n = image.length;
        int m = image[0].length;
        
        // Base case
        if (!isValidLocation(i, j, n, m,image))
            return;
        if(visited[i][j] == true)
            return;
        if(image[i][j] != originalColor)
            return;
            
        
        
        
        visited[i][j] = true;
        image[i][j] = k;
        
        //traversing the neighbours
        dfs(i, j - 1, k,originalColor, image,visited);
        dfs(i + 1, j, k, originalColor,image, visited);
        dfs(i, j + 1, k, originalColor,image, visited);
        dfs(i - 1, j, k,originalColor,image, visited);
    }
    public boolean isValidLocation(int i, int j, int n, int m, int[][] image){
        return i>=0 && i<n && j>=0 && j<m;
    }
}