//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int missingNumber(int array[], int n) {
        // // Your Code Here
        // int sum= n*(n+1)/2;
        // int as=0;
        
        // for(int i=0;i<array.length;i++){
        //     as= as+array[i];
        // }
        
        // return sum-as;
        
        int totalXor = 0;
        int arrayXor = 0;
        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }
        
        for (int num : array) {
            arrayXor ^= num;
        }
        
        return totalXor ^ arrayXor;
    }
}