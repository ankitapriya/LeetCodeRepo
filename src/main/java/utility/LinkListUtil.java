package utility;

public class LinkListUtil {

    private static ListNode createLinkList(int[] arr) {
        ListNode start = null;
        ListNode current = null;
        current = start = new ListNode(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return start;
    }

    private void printLinkList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
