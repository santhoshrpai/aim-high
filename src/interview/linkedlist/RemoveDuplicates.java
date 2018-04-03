package interview.linkedlist;

/**
 * @author rajasan
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode s = head;

        ListNode d = new ListNode(0);
        d.next = head;
        d = d.next;

        ListNode ret = d;

        int val = head.val;

        while (s != null) {
            if (s.val == val) {
                s = s.next;
            } else {
                val = s.val;
                d.next = s;
                d = d.next;
                s = s.next;
            }
        }
        d.next = null;
        return ret;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = x;
        x.next = new ListNode(2);
        x = x.next;
        x.next = new ListNode(2);
        x = x.next;
        x.next = new ListNode(3);
        x = x.next;
        x.next = new ListNode(3);
        x = x.next;
        x.next = new ListNode(5);
        x = x.next;
        x.next = new ListNode(6);
        x = x.next;
        x.next = new ListNode(6);
        x = x.next;
        x.next = new ListNode(6);
        x = x.next;
        x.next = new ListNode(6);

        RemoveDuplicates r = new RemoveDuplicates();
        y = r.deleteDuplicates(y);

        while (y != null) {
            System.out.println(y.val);
            y = y.next;
        }

    }

}
