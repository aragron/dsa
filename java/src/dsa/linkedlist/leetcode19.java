package dsa.linkedlist;

import java.util.Stack;

public class leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int size = 0;
        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            stack.add(p);
            size++;
            p = p.next;
        }
        if (size < n){
            return null;
        } else if (size == n) {
            head = head.next;
            return head;
        }
        ListNode pre = null, last = null;
        for (int i = 1; i <= n + 1; i++) {
            ListNode pop = stack.pop();
            if (i == n - 1) {
                last = pop;
            }
            if (i == n + 1) {
                pre = pop;
            }
        }
        pre.next = last;
        return head;
    }

    public static void main(String[] args) {

    }
}
