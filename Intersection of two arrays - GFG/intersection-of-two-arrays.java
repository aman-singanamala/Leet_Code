//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking count of total testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            int n, m;

            // taking count of elements in array a
            n = sc.nextInt();

            // taking count of elements in array b
            m = sc.nextInt();

            // Creating 2 arrays of n and m
            int a[] = new int[n];
            int b[] = new int[m];

            // inserting elements to array a
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // inserting elements to array b
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            // calling NumberofElementsInIntersection method
            // and printing the result
            System.out.println(ob.NumberofElementsInIntersection(a, b, n, m));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        Arrays.sort(a); // Sort array a in ascending order
    Arrays.sort(b); // Sort array b in ascending order

    int count = 0;
    int i = 0; // Pointer for array a
    int j = 0; // Pointer for array b

    while (i < n && j < m) {
        if (a[i] < b[j]) {
            i++; // Increment pointer i if a[i] is less than b[j]
        } else if (a[i] > b[j]) {
            j++; // Increment pointer j if a[i] is greater than b[j]
        } else {
            count++; // Increment count if a[i] is equal to b[j]
            i++; // Move both pointers forward to check the next elements
            j++;

            // Skip duplicates in array a
            while (i < n && a[i] == a[i - 1]) {
                i++;
            }

            // Skip duplicates in array b
            while (j < m && b[j] == b[j - 1]) {
                j++;
            }
        }
    }

    return count;
}
};
