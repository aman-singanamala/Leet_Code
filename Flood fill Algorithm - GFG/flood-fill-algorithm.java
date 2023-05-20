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
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] output = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                output[i][j] = image[i][j];
            }
        }
        
        int oldColor = output[sr][sc];
        if (oldColor == newColor) {
            return output;
        }
        
        dfs(output, sr, sc, oldColor, newColor);
        
        return output;
    }
    
    private void dfs(int[][] output, int row, int col, int oldColor, int newColor) {
        if (row < 0 || row >= output.length || col < 0 || col >= output[0].length || output[row][col] != oldColor) {
            return;
        }
        
        output[row][col] = newColor;
        
        dfs(output, row + 1, col, oldColor, newColor); // Down
        dfs(output, row - 1, col, oldColor, newColor); // Up
        dfs(output, row, col + 1, oldColor, newColor); // Right
        dfs(output, row, col - 1, oldColor, newColor); // Left
    }
}