class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        List<Integer> list = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;

        int pos = 2;

        while (curr != null && curr.next != null) {

            ListNode next = curr.next;

            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                list.add(pos);
            }

            prev = curr;
            curr = next;
            pos++;
        }

        // Less than 2 critical points
        if (list.size() < 2) {
            return new int[]{-1, -1};
        }

        int min = Integer.MAX_VALUE;

        // Minimum = distance between adjacent critical points
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }

        // Maximum = first critical point to last critical point
        int max = list.get(list.size() - 1) - list.get(0);

        return new int[]{min, max};
    }
}