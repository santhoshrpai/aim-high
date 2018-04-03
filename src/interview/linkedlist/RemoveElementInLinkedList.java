package interview.linkedlist;

/**
 * @author rajasan
 */
public class RemoveElementInLinkedList {

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode track = new ListNode(0);
        track.next = head;
        ListNode point = head;
        ListNode d = track;

        while (point != null) {
            if (point.val == val) {
                point = point.next;
            } else {
                track.next = point;
                track = track.next;
                point = point.next;
            }

        }

        track.next = null;
        return d.next;
    }

    public static ListNode removeElements1(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode y = x;
        //        x.next = new ListNode(2);
        //        x = x.next;
        //        x.next = new ListNode(6);
        //        x = x.next;
        //        x.next = new ListNode(3);
        //        x = x.next;
        //        x.next = new ListNode(4);
        //        x = x.next;
        //        x.next = new ListNode(5);
        //        x = x.next;
        //        x.next = new ListNode(6);
        //        x = x.next;
        //        x.next = new ListNode(6);
        //        x = x.next;
        //        x.next = new ListNode(6);
        //        x = x.next;
        //        x.next = new ListNode(6);

        y = removeElements(y, 1);

        while (y != null) {
            System.out.println(y.val);
            y = y.next;
        }

    }

}
