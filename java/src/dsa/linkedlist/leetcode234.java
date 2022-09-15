package dsa.linkedlist;

import java.util.List;
import java.util.Stack;

public class leetcode234 {
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.add(p);
            p = p.next;
        }
        ListNode p2 = head;
        while (p2 != null) {
            ListNode node = stack.pop();
            if (p2.val != node.val) {
                return false;
            }
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(2);
        ListNode six = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        boolean palindrome = isPalindrome(one);
        System.out.println(palindrome);
    }
}
