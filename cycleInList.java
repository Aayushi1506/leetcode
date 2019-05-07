/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.




* Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //both pointers pointing to the head initially
        
        ListNode slow=head,fast=head;
        
        //we will increase fast by two so there may be condition of fast equal to null or fast.next equals null so for cycle this condition should not occur as cycle don't terminates
        
        while(fast!=null && fast.next!=null){
            //increse slow by 1 and fast by 2
            slow=slow.next;
            fast=fast.next.next;
            //if slow becomes equal to fast it means cycle is present
            if(fast==slow){
         //to find the length of cycle move slow by one keeping fast constant and count the steps until they both become equal again       
                slow=slow.next;
                int count=1;
                while(slow!=fast){
                    slow=slow.next;
                    count++;
                }
                System.out.println(count);
                //we will increase head and slow both by 1 and the node where they will be equal will be the starting point of the cycle
                //we have its mathematical proof
                while(head!=slow){
                    head=head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
      //  if the list terminates it means there is no cycle so return null
        
        return null;
    }
}
