package dsa.linkedlist;

public class leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode sp = start;
        ListNode p = head;
        while (p != null) {
            if (p.val == val) {
                sp.next = p.next;
                p = p.next;
            } else {
                sp = sp.next;
                p = p.next;
            }
        }
        return start.next;
    }
    public static void main(String[] args) {

    }
}
