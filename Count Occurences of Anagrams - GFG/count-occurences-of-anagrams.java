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
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean allZeros(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }

    int search(String pat, String txt) {
        // code here
        int n= txt.length();
        int k= pat.length();
        
        if(n==0 ||k==0 ){
            return 0;
        }
        int result=0;
        
        int[] map= new int[26];
        for(char c: pat.toCharArray()){
            map[c-'a']++;
        }
        
        int i=0,j=0;
        while(j<n){
            map[txt.charAt(j)-'a']--;
            
            if(j-i+1==k){
                if(allZeros(map)){
                    result++;
                }
                map[txt.charAt(i)-'a']++;
                i++;
            }
            j++;
            
            
            
        }
        
        return result;
        
    }
}