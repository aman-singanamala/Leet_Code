//{ Driver Code Starts
//Initial Template for Java

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
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




//User function Template for Java
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }
}
class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        Node root= constructBST(nums, 0,nums.length-1);
        
        ArrayList<Integer> preorder= new ArrayList<>();
        preorderTraversal(root,preorder);
        int[] result = new int[nums.length];
        for(int i=0;i<preorder.size();i++){
            result[i]=preorder.get(i);
        }
        return result;
        
    }
    
    private Node constructBST(int[] nums, int left, int right){
        if(left>right){
            return null;
        }
        
        int mid= left+(right-left)/2;
        
        Node root= new Node(nums[mid]);
        root.left= constructBST(nums, left, mid-1);
        root.right= constructBST(nums, mid+1, right);
        
        return root;
    }
    
    private void preorderTraversal(Node node, List<Integer> result){
        if(node==null){
            return;
        }
        result.add(node.data);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }
}