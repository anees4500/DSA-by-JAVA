 
import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) return null;

         
        Set<Integer> removeSet = new HashSet<>();
        for (int num : nums) removeSet.add(num);

         
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;

         
        while (temp != null) {
            if (removeSet.contains(temp.val)) {
                prev.next = temp.next; 
            } else {
                prev = temp;            
            }
            temp = temp.next;          
        }

        return dummy.next;  
    }
}
