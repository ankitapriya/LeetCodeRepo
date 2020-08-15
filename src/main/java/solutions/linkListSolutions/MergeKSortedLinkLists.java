package solutions.linkListSolutions;

import utility.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLinkLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }

            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                }
                return obj.equals(this);
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, comparator);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        ListNode start = null;
        ListNode last = null;
        while (!heap.isEmpty()) {
            ListNode poll = heap.poll();
            if (poll.next != null) {
                heap.add(poll.next);
            }
            poll.next = null;
            if (start == null) {
                start = last = poll;
            } else {
                last.next = poll;
                last = poll;
            }
        }
        return start;
    }
}

