//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        // ArrayList<Integer> result= new ArrayList<Integer>();
        // for(int i=0;i<n;i++){
        //     int curr= arr[i];
        //     for(int j=i+1;j<=n;j++){
        //         if(curr==s){
        //             result.add(i+1);
        //             result.add(j);
        //             return result;
        //         }
                
        //         if(curr>s || j==n){
        //             break;
        //         }
                
        //         curr= curr+arr[j];
        //     }
        // }
        
        // result.add(-1);
        // return result;
        ArrayList<Integer> subarrayIndices = new ArrayList<>();
        int start = 0;
        int end = 0;
        int currentSum = 0;

        while (end < n) {
            currentSum += arr[end];

            while (currentSum > s && s != 0) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == s) {
                subarrayIndices.add(start + 1);
                subarrayIndices.add(end + 1);
                return subarrayIndices;
            }

            end++;
        }

        subarrayIndices.add(-1);
        return subarrayIndices;
        
    }
}