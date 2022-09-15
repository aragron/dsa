package dsa.linkedlist;

import java.util.Stack;

class leetcode430 {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node p = head;
        while (p!= null ) {
            if (p.child != null) {
                Node m = p.next;
                if (m != null) {
                    stack.add(m);
                }
                Node child = p.child;
                p.next = child;
                child.prev = p;
                p.child = null;
            } else if ( stack.size() > 0 && p.next == null) {
                Node n = stack.pop();
                p.next = n;
                n.prev = p;
            }
            p = p.next;
        }
        return head;
    }
    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }
    }
}


