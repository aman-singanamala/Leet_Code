//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int[] sorted= Arrays.copyOf(nums,nums.length);
        Arrays.sort(sorted);
        int count=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]!=sorted[i]){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]==sorted[i]){
                        int temp= nums[i];
                        nums[i]= nums[j];
                        nums[j]= temp;
                        count++;
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}