public class LinkTable {
    public static void main(String[] args) {
        Node head;
        Node node=new Node(3);
        Node node1=new Node(2);
        Node node2=new Node(1);
        Node node3=new Node(2);
        Node node4=new Node(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = node;

        Node node5=m2(head, 2);
        while (node5 != null) {
            System.out.println(node5.value + " ");
            node5 = node5.next;
        }
    }

    //给一个头指针，判断该链表是否为回文结构
    public static Boolean m1(Node head) {
        if(head == null||head.next==null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        Node n3 = null;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if(n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    //划分大于n，小于n和等于n的区域
    public static Node m2(Node head, int n) {
        Node sH = null;
        Node sT = null;
        Node bH = null;
        Node bT = null;
        Node eH = null;
        Node eT = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if(head.value < n) {
                System.out.println("执行过1");
                if(sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if(head.value == n) {
                System.out.println("执行过2");
                if(eH == null) {
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            } else if(head.value > n) {
                System.out.println("执行过3");
                if(bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        if(sH != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null? eH : bH);
    }



}

class Node{
    Node next;
    int value;

    public Node(int value) {
        this.value=value;
    }
}