//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        // // Your code here
        // char[] A= a.toCharArray();
        // char[] B= b.toCharArray();
        // if(A.length!=B.length){
        //     return false;
        // }
        
        // Arrays.sort(A);
        // Arrays.sort(B);
        
        // return Arrays.equals(A,B);
        
        
        if(a.length()!=b.length()){
            return false;
        }
        
        // int[] charCount= new int[26];
        
        // for(int i=0;i<a.length();i++){
        //     charCount[a.charAt(i)-'a']++;
        // }
        
        // for(int i=0;i<b.length();i++){
        //     charCount[b.charAt(i)-'a']--;
        // }
        
        // for(int count : charCount){
        //     if(count!=0){
        //         return false;
        //     }
        // }
        // return true;
        
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // Increment character count for string 'a'
        for (char c : a.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        // Decrement character count for string 'b'
        for (char c : b.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }

            int count = charCount.get(c);
            if (count == 0) {
                return false;
            }

            charCount.put(c, count - 1);
        }

        return true;
        
        
        
        
    }
}