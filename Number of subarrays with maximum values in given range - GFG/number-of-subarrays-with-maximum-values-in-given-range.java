//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int l = Integer.parseInt(element[1]);
		    int r = Integer.parseInt(element[2]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.countSubarrays(arr, n, l, r));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static long countSubarrays(int a[], int n, int L, int R)  
    { 
        // Complete the function
        int i = 0;
        int j = 0;
        int count = 0;
        int valid = 0;
        
        while (j < n) {
            if (a[j] >= L && a[j] <= R) {
                valid = j - i + 1;
            } else if (a[j] > R) {
                valid = 0;
                i = j + 1;
            }
            
            count += valid;
            j++;
        }
        
        return (long) count;
    } 
}

