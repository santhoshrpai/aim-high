package interview;

/**
 * @author rajasan
 */
public class problem206 {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode r = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return r;
    }

}
