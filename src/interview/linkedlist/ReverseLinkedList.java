package interview.linkedlist;

/**
 * @author rajasan
 */
public class ReverseLinkedList {

    public static ListNode reverseNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode d = new ListNode(0);
        d.next = head;
        ListNode p1 = head;
        ListNode p2 = p1.next;

        head.next = null;
        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }
        return p1;
    }

    public static ListNode reverseNodeRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode next = head.next;
        head.next = null;

        ListNode remaining = reverseNodeRecursive(next);
        next.next = head;

        return remaining;
    }

    public static ListNode reverseNodeK(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode d = new ListNode(0);
        d.next = head;
        ListNode p1 = head;
        ListNode p2 = p1.next;

        k--;
        while (p1 != null && p2 != null) {
            k--;
            if (k <= 0) {
                System.out.println(p1.val);
                System.out.println(p2.val + "===");
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

        y = reverseNodeK(y, 2);

        while (y != null) {
            System.out.println(y.val);
            y = y.next;
        }
    }

}
