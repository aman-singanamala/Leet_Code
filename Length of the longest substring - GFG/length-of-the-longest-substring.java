//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        // int max=0;
        // for(int i=0;i<s.length();i++){
        //     for(int j=i+1;j<=s.length();j++){
        //         if(allUnique(s, i,j)){
        //             max= Math.max(max, j-i);
        //         }
        //     }
        // }
        // return max;
        
         int start = 0;
        int end = 0;
        int n = s.length();
        int maxlength = 0;
        Set<Character> set = new HashSet<>();
        while (end < n) {
            char ch = s.charAt(end);
            if (!set.contains(ch)) {
                set.add(ch);
                maxlength = Math.max(maxlength, end - start + 1);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;

            }
        }
        return maxlength;
        
    }
    
    // boolean allUnique(String s, int start, int end){
    //     HashSet<Character> set= new HashSet<>();
        
    //     for(int i=start;i<end;i++){
    //         char ch = s.charAt(i);
    //         if(set.contains(ch)){
    //             return false;
    //         }
    //         set.add(ch);
            
    //     }
        
    //     return true;
    // }
}