class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];

        if (k < 2 || head == null || head.next == null) {
            arr[0] = head;
            return arr;
        }

        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        int partition = len / k;
        int extra = len % k;

        ListNode curr = head;
        ListNode prev = null;
        int index = 0;
        while (head != null) {
            arr[index++] = curr;
            for (int i = 0; i < partition && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (extra > 0) {
                prev = curr;
                curr = curr.next;
                extra--;
            }
            head = curr;
            prev.next = null;

        }
        return arr;
    }
}