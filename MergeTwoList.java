/** Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

Time Complexity: O(Min(Length of L1, Length of L2))
Space Complexity: O(1)
*/







/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //we have taken here a dummy head node and current pointer is also pointing to this node so when  when current next have address of min of both linked lists heads then dummy head next will have the head of our resultant linkedlist which is a current next
        ListNode dummyhead = new ListNode(0);
        ListNode current = dummyhead;//current pointing to the dummy head
        
        //untill one of the list is ended or one of the list pointer points to null
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                //as resultant merged list should be in ascending order
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            
            //current will start to point the node having the address in current next
            current=current.next;
        }
        //if list one is not ended
        if(l1 != null) {
            current.next = l1;
        }
        else {
            current.next = l2;
        }
        
        //this will return the first node of resultant merged list
        return dummyhead.next;

    }
}
