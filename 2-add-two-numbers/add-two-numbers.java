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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        int carry = 0;
        while(l1 != null || l2 != null || carry>0){
            int val1 = (l1!=null)?l1.val:0;
            int val2 = (l2!=null)?l2.val:0;
            int value = val1  + val2 +  carry;

            current.next = new ListNode(value%10);
            current = current.next;
            carry = value/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return dummyNode.next;
    }
}