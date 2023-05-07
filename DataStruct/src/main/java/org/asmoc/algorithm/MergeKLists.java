package org.asmoc.algorithm;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;

        return split(lists, 0, lists.length-1);

    }

    public ListNode split(ListNode[] lists, int start, int end) {
        if (start==end) {
            return lists[start];
        }

        int mid = (start+end) / 2;
        ListNode head1 = split(lists, start, mid);
        ListNode head2 = split(lists, mid+1, end);

        return merge(head1, head2);

    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (head1!=null && head2!=null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        curr.next = head1==null ? head2:head1;
        return dummy.next;
    }

}
