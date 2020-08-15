package solutions.linkListSolutions;

import utility.ListNode;

/*
https://leetcode.com/problems/reorder-list/
 */

public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return ;
        }
        ListNode middle = head, last = head;
        for(;last.next != null && last.next.next != null; middle = middle.next, last = last.next.next);
        ListNode part2= reverseList(middle.next), part1 = head;
        middle.next= null;
        ListNode node1 = part1.next;
        ListNode node2 = part2;
        ListNode start = part1;
         while(node1 != null && node2 != null) {
             ListNode node1Next = node1.next;
             ListNode node2Next = node2.next;
             start.next = node2;
             start.next.next = node1;
             start = start.next.next;
             node1 = node1Next;
             node2 = node2Next;
         }

         if(node1 != null) {
             start.next = node1;
         }
         if(node2 != null) {
             start.next = node2;
         }
    }
    
    private ListNode reverseList(ListNode n) {
        ListNode current = n, start = n, next, previous=null;
        for(; current != null ; next =  current.next, current.next = previous, previous = current, start = current, current = next);
        return start;
    }
    
}

