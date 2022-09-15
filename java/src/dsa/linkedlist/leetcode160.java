package dsa.linkedlist;

import java.util.HashSet;

public class leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1  = headA, p2 = headB;
        while ( p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            }  else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2= headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public static void main(String[] args) {

    }
}
