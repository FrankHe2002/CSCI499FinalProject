```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int numOfNodes = count(head);
        ListNode ptr = null;
        List<ListNode> start = new ArrayList<>(), end = new ArrayList<>();
        ListNode f = null;
        while (numOfNodes >= k) {
            start.add(head);
            int count = 0;
            while (count < k) {
                ListNode temp = head.next;
                head.next = ptr;
                ptr = head;
                head = temp;
                count++;
                numOfNodes--;
            }
            end.add(ptr);
            ptr = null;
        }
        f = head;
        int n = start.size();
        for (int i = 0; i < n - 1; i++) start.get(i).next = end.get(i + 1);
        start.get(n - 1).next = f;
        return end.get(0);
    }

    public int count(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
```