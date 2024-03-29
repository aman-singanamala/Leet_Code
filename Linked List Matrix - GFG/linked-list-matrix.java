//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.Scanner;
class Node
{
    int data;
    Node right,down;
    
    Node(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
public class Linked_list_2D_Matrix {
 
    // node of linked list
 
    static void display(Node head) {
         
        Node Rp;
    	Node Dp = head;
    	while (Dp != null) {
    		Rp = Dp;
    		while (Rp != null) {
    			System.out.print(Rp.data + " ");
    			if(Rp.right != null) System.out.print(Rp.right.data + " ");
    			else System.out.print("Null ");
    			if(Rp.down != null)System.out.print(Rp.down.data + " ");
    			else System.out.print("Null ");
    			Rp = Rp.right;
    		}
    		
    		Dp = Dp.down;
    	}
    }
 
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
        int n=sc.nextInt();
        int [][]arr=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
            int p=sc.nextInt();arr[i][j]=p;}
        }
        GFG obj=new GFG();
        Node head = obj.construct(arr, n);
        display(head);
        System.out.println();
        }
    }
 
}
// } Driver Code Ends


//User function Template for Java

 /*class Node

class Node
{
    int data;
    Node right,down;
    
    Node(int data){
        this.data = data;
        right = null;
        down = null;
    }
}
*/
/*Function should return the head of the 2D LL.*/
class GFG
{
    static Node construct(int arr[][],int N)
    {
        //Add your code here.
        Node[][] nodeMatrix= new Node[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                nodeMatrix[i][j]= new Node(arr[i][j]);
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                nodeMatrix[i][j].right= nodeMatrix[i][j+1];
            }
        }
        
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N;j++){
                nodeMatrix[i][j].down= nodeMatrix[i+1][j];
            }
        }
        
        return nodeMatrix[0][0];
    }
}