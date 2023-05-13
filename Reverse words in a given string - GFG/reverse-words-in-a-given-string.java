//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        String[] str= S.split("\\.");
        int n= str.length;
        for(int i=0;i<n/2;i++){
            String temp= str[i];
            str[i]= str[n-i-1];
            str[n-i-1]= temp;
        }

        StringBuilder ans= new StringBuilder();
        for (String s : str) {
            ans.append(s).append(".");
        }
        
        return ans.substring(0, ans.length()-1);
        
    }
}