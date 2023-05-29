//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            // If the array is already sorted, no rotation has occurred
            if (arr[low] <= arr[high])
                return low;

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            // Check if the mid element is the smallest element
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev])
                return mid;

            // If the right half is sorted, the rotation lies in the left half
            if (arr[mid] <= arr[high])
                high = mid - 1;
            // If the left half is sorted, the rotation lies in the right half
            else if (arr[mid] >= arr[low])
                low = mid + 1;
        }

        return -1;
    }
}