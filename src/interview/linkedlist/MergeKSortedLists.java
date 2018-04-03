package interview.linkedlist;

import java.util.PriorityQueue;

/**
 * @author rajasan
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val == o2.val) {
                return 0;
            } else if (o1.val > o2.val) {
                return 1;
            } else {
                return -1;
            }
        });

        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }

        ListNode l = new ListNode(0);
        ListNode d = l;

        while (!q.isEmpty()) {
            ListNode l1 = q.poll();
            d.next = l1;
            d = d.next;

            if (l1.next != null) {
                q.add(l1.next);
            }
        }

        return l.next;

    }

    public static void main(String[] args) {
        //        ListNode[] x =

        //        [[11,12,13],[1,2,3],[22],[0]]

    }

}
