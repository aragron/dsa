package dsa.linkedlist;

import java.util.Objects;

class MyLinkedList {
    private int size;
    private ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {return -1;}
        ListNode curr = head;
        for (int i = 0; i <= index; ++i) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index>size) {return;}
        if (index<0){index=0;}
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode node = new ListNode(val);
        node.next = pred.next;
        pred.next = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {return;}
        size--;
        ListNode pred = head;
        for(int i = 0; i < index; ++i) {pred = pred.next;}
        pred.next = pred.next.next;
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        ListNode listNode = (ListNode) o;
        return val == listNode.val && next.equals(listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
