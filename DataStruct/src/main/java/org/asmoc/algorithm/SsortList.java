package org.asmoc.algorithm;

public class SsortList {

    public ListNode sortList(ListNode head) {

        if (head==null || head.next==null) return head;


        ListNode fast = head.next, slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode head1 = sortList(head);
        head2 = sortList(head2);

        return  merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (head1!=null && head2!=null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }

        if (head1!=null) p.next = head1;
        else p.next = head2;
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(3);

        SsortList s = new SsortList();
        ListNode t = s.sortList(head);
        while (t!=null) {
            System.out.println(t.val);
            t = t.next;
        }
    }

}
