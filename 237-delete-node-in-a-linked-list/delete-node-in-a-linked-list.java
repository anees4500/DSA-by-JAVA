/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;     // Copy next node's value into current
        node.next = node.next.next;   // Skip over the next node
    }
}
