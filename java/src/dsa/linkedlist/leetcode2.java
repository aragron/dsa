package dsa.linkedlist;

import java.util.Stack;

public class leetcode2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode prev = new ListNode(-1);
        ListNode node = prev;
        int increase = 0;
        while (increase > 0 || l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            if (l1 != null) {l1 = l1.next;}
            if (l2 != null) {l2 = l2.next;}

            int sum = n1 + n2 + increase;
            increase = sum/10;
            node.next = new ListNode(sum%10);
            node = node.next;
        }
        return prev.next;
    }
    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);

        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(4);
        one.next = two;
        two.next = three;
        //three.next = four;
        four.next = five;
        five.next = six;

        ListNode listNode = addTwoNumbers(one, four);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
