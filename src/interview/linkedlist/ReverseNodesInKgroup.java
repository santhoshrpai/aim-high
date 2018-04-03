package interview.linkedlist;

/**
 * @author rajasan
 */
public class ReverseNodesInKgroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode t = head;
        while (t != null) {
            len++;
            t = t.next;
        }

        if (k > len) {
            return head;
        }

        ListNode start = head;

        int it = len / k;
        while (it > 0) {
            ListNode onePrevious = reverseNodeK(start, k);
            start = onePrevious.next;
            it--;
        }
        return head;
    }

    public static ListNode reverseNodeK(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode d = new ListNode(0);
        d.next = head;
        ListNode p1 = head;
        ListNode p2 = p1.next;

        ListNode breakNode = null;

        k--;
        while (p1 != null && p2 != null) {
            k--;
            if (k <= 0) {
                breakNode = p2;
                break;
            }
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        head.next = p2;
        return p1;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = x;

        int i = 2;
        while (i != 10) {
            x.next = new ListNode(i++);
            x = x.next;
        }

        y = reverseKGroup(y, 2);

        while (y != null) {
            System.out.println(y.val);
            y = y.next;
        }
    }

}
