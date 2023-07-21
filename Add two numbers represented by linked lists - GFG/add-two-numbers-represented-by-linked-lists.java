//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
     static Node addTwoLists(Node first, Node second) {
        // Reverse the two input linked lists to simplify the addition.
        first = reverseLinkedList(first);
        second = reverseLinkedList(second);

        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        int sum;
        int x, y;

        while (first != null || second != null) {
            if (first != null) {
                x = first.data;
                first = first.next;
            } else {
                x = 0;
            }

            if (second != null) {
                y = second.data;
                second = second.next;
            } else {
                y = 0;
            }

            sum = x + y + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        // Add the carry node if needed
        if (carry > 0) {
            curr.next = new Node(carry);
        }

        // Reverse the resulting linked list to get the correct order of digits.
        return reverseLinkedList(dummy.next);
    }

    // Helper function to reverse a linked list.
    static Node reverseLinkedList(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        Node dummy = new Node(0);
        Node curr = dummy;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;

        return dummy.next;
    }
}