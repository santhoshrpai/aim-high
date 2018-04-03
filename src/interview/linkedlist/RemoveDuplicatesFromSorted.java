package interview.linkedlist;

/**
 * @author rajasan
 */
public class RemoveDuplicatesFromSorted {

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode g = head;

        ListNode d = new ListNode(0);
        ListNode m = d;
        m.next = head;

        while (g != null) {

            while (g.next != null && g.val == g.next.val) {
                g = g.next;
            }

            if (m.next != g) {
                m.next = g.next;
                g = m.next;
            } else {
                m = m.next;
                g = g.next;
            }
        }

        return d.next;

    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = x;
        x.next = new ListNode(1);
        x = x.next;
        x.next = new ListNode(1);
        x = x.next;
        x.next = new ListNode(1);
        x = x.next;
        x.next = new ListNode(2);
        x = x.next;
        x.next = new ListNode(3);
        x = x.next;
        x.next = new ListNode(3);
        x = x.next;
        x.next = new ListNode(4);
        x = x.next;
        x.next = new ListNode(4);

        ListNode z = deleteDuplicates(y);
        System.out.println(z.val);
    }
}
