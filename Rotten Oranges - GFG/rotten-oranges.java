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


class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        int n = grid.length; // Number of rows in the grid
        int m = grid[0].length; // Number of columns in the grid
        Queue<Pair> queue = new LinkedList<>(); // Queue to store the indices of rotten oranges
        int[][] visited = new int[n][m]; // Array to track visited cells
        int cntFresh = 0; // Count of fresh oranges

        // Traverse the grid to find rotten oranges and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) { // If an orange is rotten
                    queue.add(new Pair(i, j, 0)); // Add its indices to the queue
                    visited[i][j] = 2; // Mark the cell as visited
                } else if (grid[i][j] == 1) { // If an orange is fresh
                    cntFresh++; // Increment the count of fresh oranges
                }
            }
        }

        int tm = 0; // Variable to track time (minutes)
        int[] drow = {-1, 0, 1, 0}; // Array representing the change in row indices for 4 directions (up, right, down, left)
        int[] dcol = {0, 1, 0, -1}; // Array representing the change in column indices for 4 directions (up, right, down, left)
        int cnt = 0; // Count of infected oranges

        // Perform BFS traversal until the queue is empty
        while (!queue.isEmpty()) {
            Pair curr = queue.poll(); // Dequeue the current orange
            int row = curr.row; // Get the row index of the current orange
            int col = curr.col; // Get the column index of the current orange
            tm = curr.tm; // Get the time (minutes) required to rot the current orange

            // Check all 4 directions from the current orange
            for (int i = 0; i < 4; i++) {
                int newRow = row + drow[i]; // Calculate the new row index
                int newCol = col + dcol[i]; // Calculate the new column index

                // Check if the new indices are valid and the cell is not visited and contains a fresh orange
                if (isValid(newRow, newCol, n, m) && visited[newRow][newCol] != 2 && grid[newRow][newCol] == 1) {
                    visited[newRow][newCol] = 2; // Mark the cell as visited
                    queue.add(new Pair(newRow, newCol, tm + 1)); // Add the new orange to the queue
                    cnt++; // Increment the count of infected oranges
                }
            }
        }

        // Check if all fresh oranges are infected, return the time required; otherwise, return -1
        return (cnt == cntFresh) ? tm : -1;
    }

    // Function to check if indices are valid
    private boolean isValid(int row, int col, int n, int m) {
        return (row >= 0 && row < n && col >= 0 && col < m);
    }
}

class Pair {
    int row;
    int col;
    int tm;

    public Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}