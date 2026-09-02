class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        List<Integer> list = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;

        if(curr.next==null){
            return new int[]{-1,-1};
        }

        int pos = 2;

        int fc = -1;
        int lc = -1;
        int pc = -1;

        int min = Integer.MAX_VALUE;

        

        while (curr != null && curr.next != null) {

            ListNode next = curr.next;

            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                if(fc==-1){
                    fc = pos;
                    pc = pos;
                    lc = pos;
                }
                else{
                    lc = pos;
                    min = Math.min(min, lc - pc);
                    pc = pos;
                }

                

                
            }

            prev = curr;
            curr = next;
            pos++;
        }

        if(min==Integer.MAX_VALUE || min==0){
            return  new int[]{-1, -1};
        }

        int max = lc - fc;

         

        return new int[]{min, max};
    }
}