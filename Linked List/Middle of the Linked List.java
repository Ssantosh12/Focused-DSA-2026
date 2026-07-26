/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // we create two reference pointer variables, slow and fast pointers
        // one moves one by one node, faster moves two nodes each time

        ListNode slowPointer,fastPointer;

        // both pointers starts pointing to the first node
        slowPointer=head;
        fastPointer=head;

        // so when fast pointer reaches last node or one beyond last node
        // the  slow pointer correctly points to middle node (2nd middle if two)
        // NOTICE in both how we are using the reference pointers themselves to iterate the Linked List
        // this comes from OOP knowledge and uunderstaning (reference and value types in OOP)
        while(fastPointer!=null&&fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
        }
        return slowPointer;
    }
}
