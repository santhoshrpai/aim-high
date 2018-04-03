package interview.linkedlist;

/**
 * @author rajasan
 */
public class ReversePartOfLinkedList {

    public static ListNode reverse(ListNode head, int start, int end) {

        if (head == null || start < 0 || end < 0) {
            return head;
        }

        int countNodes = countNodes(head);

        if (start >= countNodes || end > countNodes) {
            return head;
        }

        //        int k = 0;
        //        ListNode curr = head;
        //        ListNode prev = new ListNode(0);
        //        prev.next = head;
        //
        //        while (k < start) {
        //            curr = curr.next;
        //            prev = prev.next;
        //            k++;
        //        }

        //        ListNode startReversalNode = curr;
        //        ListNode next = curr.next;
        //
        //        while (next != null && k < end) {
        //            curr.next = prev;
        //            prev = curr;
        //            curr = next;
        //            next = next.next;
        //            k++;
        //        }
        //
        //        curr.next = prev;
        //
        //        ListNode before = startReversalNode.next;
        //        startReversalNode.next = next;
        //
        //        if (before.val == 0) {
        //            head = curr;
        //        } else {
        //            before.next = curr;
        //        }
        // return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        int k = 1;

        while (k++ < start) {
            curr = curr.next;
        }

        ListNode before = curr.next;

        while (start++ < end) {
            ListNode next = before.next;
            before.next = next.next;
            next.next = curr.next;
            curr.next = next;
        }

        return dummy.next;
    }

    public static int countNodes(ListNode head) {
        int count = 0;

        ListNode t = head;

        while (t != null) {
            count++;
            t = t.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode z = x;

        int i = 2;
        while (i != 8) {
            x.next = new ListNode(i++);
            x = x.next;
        }

        ListNode y = z;

        while (y != null) {
            System.out.print(y.val + "->");
            y = y.next;
        }

        System.out.println("null");

        y = reverse(z, 1, 4);

        while (y != null) {
            System.out.print(y.val + "->");
            y = y.next;
        }
        System.out.println("null");
    }

}
