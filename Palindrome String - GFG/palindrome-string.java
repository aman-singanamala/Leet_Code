//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        if(S.length()<=1){
            return 1;
        }
        boolean ans= helper(S, 0, S.length()-1);
        if(ans==true){
            return 1;
        }else{
            return 0;
        }
    }
    boolean helper(String S, int left, int right){
        if(left>=right){
            return true;
        }else if (S.charAt(left)!=S.charAt(right)){
            return false;
        }else{
            return helper(S, left+1, right-1);
        }
    }
};