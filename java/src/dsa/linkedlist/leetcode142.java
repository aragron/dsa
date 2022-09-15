package dsa.linkedlist;

public class leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null|| fast.next == null) {return null;}
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {break;}
        }
        ListNode ptr = head;
        while (slow != ptr) {
            slow = slow.next;
            ptr = ptr.next;
        }
        return ptr;
    }
    public static void main(String[] args) {

    }
}
