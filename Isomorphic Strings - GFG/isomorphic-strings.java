//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String a,String b)
    {
        // Your code here
        Map<Character, Character> amap= new HashMap<>();
        Map<Character, Character> bmap= new HashMap<>();
        
        if(a.length()!=b.length()){
            return false;
        }
        
        for(int i=0;i<a.length();i++){
            char achar = a.charAt(i);
            char bchar = b.charAt(i);
            
            
            if(amap.containsKey(achar)){
                if(amap.get(achar)!=bchar){
                    return false;
                }
            }else{
                amap.put(achar, bchar);
            }
            
            
            
            if(bmap.containsKey(bchar)){
                if(bmap.get(bchar)!=achar){
                    return false;
                }
            }else{
                bmap.put(bchar, achar);
                }
        }
        
        return true;
    }
}