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
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2];

        // Perform cyclic sort
        for (int i = 0; i < n; i++) {
            while (arr[i] != i + 1) {
                // Check for the repeating number
                if (arr[i] == arr[arr[i] - 1]) {
                    result[0] = arr[i];
                    break;
                }
                // Swap the numbers to their correct positions
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Find the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                result[1] = i + 1;
                break;
            }
        }

        return result;
    }
}
