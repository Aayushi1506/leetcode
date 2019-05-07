/**

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL



 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 1.Three pointers Method.
class Solution {
    public ListNode reverseList(ListNode head) {
      //three pointers one pointing to head and two pointing null 
       ListNode current = head,ptr=null,prev=null;
        while(current != null){
            //ptr points to next node of current
            ptr = current.next;
            //give current next the address of prev
            current.next = prev;
            //point prev to the node pointed by current
            prev = current;
            //point current to the the node to which ptr is pointing
            current = ptr;
        }
        /*as prev is poiting to the last node or first node of reversed list so head will 
        point it and head will be returned*/
        head = prev;
        return head;
    }
}
*******************************************************************************************************************************
   //2.Using Recursion Method.
    
    class Solution {
    public ListNode reverseList(ListNode head) {
       //if list is empty
        if(head==null){
            return null;
        }
        //if there is only 1 element in list
        else if(head.next==null){
            return head;
        }
        //if more than one element in list
        else{
            //nextnode will point to 2nd node of remaining list
            ListNode nextnode = head.next;
           // head node next will given null so it will not point any node
            head.next=null;
            /* now to reverse the rest of list starting from nextnode again the method will be 
            called and nextnode will be given as a head*/
            ListNode rest = reverseList(nextnode);
            //when the condition of 1 element in a list is satisfied i.e head.next is null head will be returned and that recursion will be poped from stack
            //now head will be the node before nextnode so its next will be given the address of head and in this fashion the given list is reversed 
            nextnode.next=head;
            // and the reversed list is contained by rest node so it will be returned after each recursion
            return rest;
        }
        
        
    }
}
