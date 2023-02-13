package org.asmoc.algorithm;

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

public class InsertNode {
    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node tmp = new Node(insertVal);
            tmp.next = tmp;
            head = tmp;
        }
        else if (head.next == head) {
            Node tmp = new Node(insertVal);
            head.next = tmp;
            tmp.next = head;
        } else {
            Node maxNode = head;
            Node curr = head;
            Node next = head.next;

            while (!(curr.val <= insertVal && next.val >= insertVal) && next != head) {
                curr = next;
                next = next.next;
                if (curr.val > maxNode.val) {
                    maxNode = curr;
                }
            }

            Node insertNode = new Node(insertVal);
            if (curr.val <= insertVal && next.val >= insertVal) {
                insertNode.next = next;
                curr.next = insertNode;
            } else {
                insertNode.next = maxNode.next;
                maxNode.next = insertNode;
            }
        }

        return head;

    }
}
