//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long pre = 1; // Initialize prefix product as 1
        long suff = 1; // Initialize suffix product as 1
        long maxProduct = Long.MIN_VALUE; // Initialize maxProduct to the smallest possible value
        
        for (int i = 0; i < n; i++) {
            // Handle cases where previous or suffix product becomes 0
            if (pre == 0) {
                pre = 1;
            }
            if (suff == 0) {
                suff = 1;
            }
            
            // Multiply current element with pre and suffix products
            pre *= arr[i];
            suff *= arr[n - i - 1];
            
            // Update maxProduct with the maximum among previous answer, pre, and suff
            maxProduct = Math.max(maxProduct, Math.max(pre, suff));
        }
        
        return maxProduct;
    }
}
