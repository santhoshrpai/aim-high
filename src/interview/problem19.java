package interview;

/**
 * @author rajasan
 */
public class problem19 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int i = 1;
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode first = d;
        ListNode second = d;

        while (i < n && second.next != null) {
            second = second.next;
            i++;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return head;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        removeNthFromEnd1(x, 1);
    }
}