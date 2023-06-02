//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        // ArrayList<Integer> result= new ArrayList<Integer>();
        
        // for(int i=0;i<=n-k;i++){
        //     int currmax= Integer.MIN_VALUE;
        //     for(int j=i;j<i+k;j++){
        //         currmax= Math.max(currmax, arr[j]);
        //     }
        //     result.add(currmax);
        // }
        
        // return result;
        ArrayList<Integer> ans= new ArrayList<>();
        int wm= 0;
        
        for(int i=0;i<k;i++){
            wm= Math.max(wm, arr[i]);    
        }
        
        ans.add(wm);
        
        
        for(int i=k;i<n;i++){
            int left= arr[i-k]; // element going out of the window
            int right=arr[i] ;// new element in the window
            
            if(left==wm){
                wm=right;
                int j=i-k+1;
                while(j<=i){
                    wm= Math.max(wm, arr[j]);
                    j++;
                }
            }
            else{
                wm= Math.max(wm, right);
            }
            
            ans.add(wm);
            
        }
        
        return ans;
        
    }
}