//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        // for(int i=0;i<size;i++){
        //     for(int j=i+1;j<size;j++){
        //         if(Math.abs(arr[i]-arr[j])==n){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++){
            int x= arr[i]+n;
            int left= i+1;
            int right= size-1;
            
            while(left<=right){
                int mid= left+(right-left)/2;
                
                if(arr[mid]==x){
                    return true;
                }
                else if(arr[mid]<x){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }
}