//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        if(K==1){
            return arr[0];
        }
        
        Node head= arr[0];
        for(int i=1;i<K;i++){
            head= sortedMerge(head, arr[i]);
        }
        return head;
    }
    
    
    Node sortedMerge(Node head1, Node head2) {
     // This is a "method-only" submission. 
     // You only need to complete this method
        Node dummy= new Node(0);
        Node curr= dummy;
        
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        
        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                curr.next= head1;
                head1= head1.next;
            }else{
                curr.next= head2;
                head2= head2.next;
            }
            curr= curr.next;
        }
        
        while(head1!=null){
            curr.next= head1;
            curr= curr.next;
            head1= head1.next;
        }
        
        while(head2!=null){
            curr.next= head2;
            curr=curr.next;
            head2= head2.next;
        }
        
        return dummy.next;
   } 
    
}
