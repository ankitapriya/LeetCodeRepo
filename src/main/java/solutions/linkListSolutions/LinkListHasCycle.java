package solutions.linkListSolutions;

import utility.ListNode;

/*
https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkListHasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoSteps = head;
        oneStep = oneStep != null ? oneStep.next : null;
        twoSteps = twoSteps != null && twoSteps.next != null ? twoSteps.next.next : null;
        while (oneStep != null && twoSteps != null) {
            if (oneStep == twoSteps) {
                return true;
            }
            oneStep = oneStep.next;
            twoSteps = twoSteps.next != null ? twoSteps.next.next : null;
        }
        return false;
    }
}
