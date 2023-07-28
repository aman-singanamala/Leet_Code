//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends




//User function Template for Java
class Solution {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long maxSum = 0;
        long windowSum = 0;

        // Convert the ArrayList to a simple array for faster access
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arr.get(i);
        }

        // Calculate the initial window sum
        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Slide the window and update the maximum sum
        for (int i = K; i < N; i++) {
            int left = arr[i - K];
            int right = arr[i];

            windowSum = windowSum - left + right;
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }
}

