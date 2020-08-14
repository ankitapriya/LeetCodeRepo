package solutions;

import utility.ListNode;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode nthNodeFromCurrent = head;
        ListNode previous = null;
        for(int i= 1 ;i<n && nthNodeFromCurrent != null ;i++, nthNodeFromCurrent = nthNodeFromCurrent.next);
        if(nthNodeFromCurrent == null) {
            return null;
        }
        
        for(;nthNodeFromCurrent.next != null; previous = current, nthNodeFromCurrent = nthNodeFromCurrent.next, current = current.next);
        ListNode start = remove(previous, head);
        return start;
    }

    private ListNode remove(ListNode previous, ListNode head) {
        if(previous == null) {
            return head.next;
        }
        if(previous.next != null) {
            previous.next = previous.next.next;
        }
        return head;
    }
}
