//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        while(t > 0)
        {
            //taking elements count
            int n = sc.nextInt();
            
            //creating an array of length n
            int arr[] = new int[n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            
            //creating an object of class Solutions
            Solution ob = new Solution();
            
            //calling the method findNumberOfTriangles()
            //of class Solutions and printing the results
            System.out.println(ob.findNumberOfTriangles(arr,n));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
         // Sort the array in ascending order
        Arrays.sort(arr);
        
        // Initialize count of triangles
        int count = 0;
        
        // Fix the first element and find other two
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            
            // Find the rightmost element which can form a triangle with the fixed element
            for (int j = i + 1; j < n; j++) {
                while (k < n && arr[i] + arr[j] > arr[k])
                    k++;
                
                // The number of triangles that can be formed with the current fixed element is the difference between
                // the index of the rightmost element and the second element
                count += k - j - 1;
            }
        }
        
        return count;
    }
}