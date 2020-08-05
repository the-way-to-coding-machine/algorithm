package org.wtcm.leetcode.q2;

public class AddTwoNumbers_JY {
    /**
     * ListNode is a Linked list and its each node have single digit.
     * The Whole digits is a reversed number.
     * find two ListNodes' sum.
     * <p>
     * e.g)
     * input:
     * l1: 2-> 4-> 3, l2: 5-> 6-> 4
     * <p>
     * ouput:
     * 7-> 0-> 8
     * (342 + 465 = 807)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr = new ListNode();
        ListNode result = ptr;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum > 9 ? 1 : 0;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
        }
        if (carry == 1) {
            ptr.next = new ListNode(1);
        }
        return result.next;
    }
}