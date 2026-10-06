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
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || k==0){
            return head;
        }

        if(head.next==null){
            return head;
        }

        ListNode tp = head;
        int size = 0;

        while(tp!=null){
            tp = tp.next;
            size++;
        }

        k =  k % size;
        
        while(k-->0){
            ListNode temp = head;
            ListNode prev  = null;
            while(temp.next!=null){
                prev = temp;
                temp = temp.next;
            }

            prev.next = null;

            temp.next = head;
            head = temp;
        }

        return head;
    }
}