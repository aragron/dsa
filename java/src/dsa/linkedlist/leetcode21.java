package dsa.linkedlist;

public class leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode pre = node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return node.next;
    }
    public static void main(String[] args) {

    }
}
