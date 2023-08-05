//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        if (arr == null || arr.length == 0) {
        return "-1"; // Return -1 when there's no common prefix
    }

    String ans = arr[0];
    for (int i = 1; i < n; i++) {
        String curr = arr[i];

        int j = 0;
        while (j < curr.length() && j < ans.length() && ans.charAt(j) == curr.charAt(j)) {
            j++;
        }

        ans = ans.substring(0, j);

        if (ans.isEmpty()) {
            return "-1"; // Return -1 when there's no common prefix
        }
    }

    return ans;
    }
}