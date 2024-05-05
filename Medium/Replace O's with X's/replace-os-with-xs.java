//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}

class Solution{
    static char[][] fill(int n, int m, char a[][]){
    
        boolean[][] visited = new boolean[n][m];
        
        bfs(a,visited);
        
        return a;
    }
    static void bfs(char[][] a, boolean[][] visited)
    {
        int n = a.length;
        int m = a[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        //columns
        for(int i=0; i<n; i++){
            if(a[i][0] == 'O' && !visited[i][0]){
                q.add(new Pair(i,0));
                visited[i][0] = true;
            }
            if(a[i][m-1] == 'O' && !visited[i][m-1]){ // corrected from n-1 to m-1
                q.add(new Pair(i,m-1));
                visited[i][m-1] = true;
            }
        }
        //rows
        for(int j=0; j<m; j++){ // corrected from i<m to j<m
            if(a[0][j] == 'O' && !visited[0][j]){
                q.add(new Pair(0,j));
                visited[0][j] = true;
            }
            if(a[n-1][j] == 'O' && !visited[n-1][j]){ 
                q.add(new Pair(n-1,j));
                visited[n-1][j] = true;
            }
        }
        
        //level order traversal
        while(q.size() > 0){
            Pair rem = q.poll();
            int row = rem.first;
            int col = rem.second;
            // up
            if (isValidLocation(row - 1, col, n, m) && a[row - 1][col] == 'O' && !visited[row - 1][col]) {
                q.add(new Pair(row - 1, col));
                visited[row - 1][col] = true;
            }
            // right
            if (isValidLocation(row, col + 1, n, m) && a[row][col + 1] == 'O' && !visited[row][col + 1]) {
                q.add(new Pair(row, col + 1));
                visited[row][col + 1] = true;
            }
            // down
            if (isValidLocation(row + 1, col, n, m) && a[row + 1][col] == 'O' && !visited[row + 1][col]) {
                q.add(new Pair(row + 1, col));
                visited[row + 1][col] = true;
            }
            // left
            if (isValidLocation(row, col - 1, n, m) && a[row][col - 1] == 'O' && !visited[row][col - 1]) {
                q.add(new Pair(row, col - 1));
                visited[row][col - 1] = true;
            } 
        }
        
       
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){ 
                if(!visited[i][j] && a[i][j]== 'O'){
                    a[i][j] = 'X';
                }
            }
        }
    }
    static boolean isValidLocation(int i, int j, int n, int m) { 
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
