package dsa.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);

        linkedList.list();

        System.out.println("============");
        Node node = new Node(4, "公孙胜", "入云龙");
        linkedList.update(node);
        linkedList.list();
        System.out.println("============");
        linkedList.delete(3);
        linkedList.list();

    }
}


class DoubleLinkedList {
    private final Node head = new Node(0, "", "");

    public Node getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void update(Node newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newNode.name;
            temp.nickname = newNode.nickname;
        } else {
            System.out.printf("未找到需要修改的目标节点：%d\n", newNode.no);
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法无法删除");
        }
        Node temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的节点不存在:%d\n", no);
        }
    }

}

class Node {
    public int no;
    public String name;
    public String nickname;
    public Node next;
    public Node pre;

    public Node(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
