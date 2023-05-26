//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        // ArrayList<Integer> ans= new ArrayList<>();
        // for(int i=0;i<=n-k;i++){
        //     Set<Integer> set= new HashSet<Integer>();
        //     for(int j=i;j<i+k;j++){
        //         set.add(A[j]);
        //     }
            
        //     ans.add(set.size());
        
        // }
        
        // return ans;
            ArrayList<Integer> disticntCounts= new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        
        for(int i=0;i<k;i++){
            if(map.containsKey(A[i])){
                map.put(A[i], map.get(A[i])+1);
            }else{
                map.put(A[i], 1);
            }
        
            if(map.get(A[i])==1){
                count++;
            }
        }
        disticntCounts.add(count);
        
        
        for(int i=k;i<n;i++){
            int left= A[i-k];
            int right= A[i];
            
            map.put(left, map.get(left)-1);
            
            if(map.get(left)==0){
                count--;
            }
            
            
            if(map.containsKey(right)){
                map.put(right, map.get(right)+1);
            }else{
                map.put(right, 1);
            }
            
            
            
            if(map.get(right)==1){
                count++;
            }
            
            disticntCounts.add(count);
        }
        
        return disticntCounts;
    }
}

