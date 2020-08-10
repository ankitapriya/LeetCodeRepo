import utility.ListNode;


/*
  https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkList {
    
        public ListNode reverseListIteratively(ListNode head) {
            ListNode currentNode = head;
            ListNode startNode = head;
            ListNode previousNode = null;
            while(currentNode != null) {
                startNode = currentNode;
                ListNode next = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = next;
            }
            return startNode;
        }


    public ListNode reverseListRecursively(ListNode head) {
            return reverseListRecursivelyUtil(head, null);
    }

    private ListNode reverseListRecursivelyUtil(ListNode currentNode, ListNode previousNode) {
        if(currentNode  == null) {
            return null;
        }
        if(currentNode.next == null) {
            currentNode.next = previousNode;
            return currentNode;
        }
        ListNode nextNode = currentNode.next;
        currentNode.next = previousNode;
        return reverseListRecursivelyUtil(nextNode, currentNode);
    }
}
