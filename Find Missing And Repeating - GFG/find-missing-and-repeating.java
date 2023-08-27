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
        int[] ans = new int[2];
        int sumN = n * (n + 1) / 2;
        int arrSum = 0;
        
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
        }
        
        int diff = sumN - arrSum; // Calculate the missing number
        
        // Find the two elements that sum up to 'diff'
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        
        // 'xor' now contains the XOR of the two missing elements
        // Find the rightmost set bit in 'xor'
        int rightmostSetBit = xor & -xor;
        
        int num1 = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & rightmostSetBit) == 0) {
                num1 ^= arr[i];
            } else {
                num2 ^= arr[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & rightmostSetBit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        
        // Check which number is missing from the array and assign it to 'ans'
        for (int i = 0; i < n; i++) {
            if (arr[i] == num1) {
                ans[0] = num1;
                ans[1] = num2;
                break;
            }
            if (arr[i] == num2) {
                ans[0] = num2;
                ans[1] = num1;
                break;
            }
        }
        
        return ans;
    }
}
