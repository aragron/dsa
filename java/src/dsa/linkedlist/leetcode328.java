package dsa.linkedlist;


public class leetcode328 {
    public static ListNode oddEvenList(ListNode head) throws InterruptedException {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) throws InterruptedException {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
//        ListNode p = one;

        ListNode p = oddEvenList(one);
        while (p!= null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
