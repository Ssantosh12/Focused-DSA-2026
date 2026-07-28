/**
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
    public boolean hasCycle(ListNode head) {
        // we create method level (local scope) hashmap
        // to store which list nodes have been visited

        // hash map object instantiation
        Map<ListNode,Boolean> visitedNodes=new HashMap<>();

        // we create a reference pointer variable to iterate the linked list
        // it starts with pointing the first head node
        ListNode ptrNode=head;

        // NOTE: use visitedNodes.containsKey(key) instead of visitedNodes.get(key)
        while(ptrNode!=null&&visitedNodes.containsKey(ptrNode)==false){
            visitedNodes.put(ptrNode,true);

            // ptrNode moves to poit next list node
            ptrNode=ptrNode.next;
        }

        // so after above if we stopped at non-null then there is a cycle
        if(ptrNode!=null)
            return true;
        return false;
    }
}
