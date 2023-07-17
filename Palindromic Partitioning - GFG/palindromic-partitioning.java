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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int palindromicPartition(String str) {
        int n = str.length();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return helper(str, 0, n - 1, memo);
    }

    static int helper(String str, int i, int j, int[][] memo) {
        if (i >= j || isPalindrome(str, i, j)) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int minCuts = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cuts = 1 + helper(str, i, k, memo) + helper(str, k + 1, j, memo);
            minCuts = Math.min(minCuts, cuts);
        }
        memo[i][j] = minCuts;
        return minCuts;
    }

    static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
