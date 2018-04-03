package interview;

/**
 * @author rajasan
 */
public class problem2 {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode first, ListNode second) {

        if (first == null && second == null) {
            return null;
        }

        ListNode result = new ListNode(0);
        ListNode resultHead = result;
        int carry = 0;

        while (first != null || second != null || carry != 0) {

            int sum = (first != null ? first.val : 0) + (second != null ? second.val : 0) + carry;

            carry = sum / 10;

            result.next = new ListNode(sum % 10);
            result = result.next;

            first = first != null ? first.next : null;
            second = second != null ? second.next : null;
        }

        return resultHead.next;
    }
}