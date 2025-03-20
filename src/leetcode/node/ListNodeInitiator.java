package leetcode.node;

public class ListNodeInitiator {
    public static ListNode init(int[] arr) {
        ListNode resHead = arr.length > 0 ? new ListNode() : null;
        ListNode next = resHead;
        for (int i = 0; i < arr.length; i++) {
            next.val = arr[i];
            if (i < arr.length - 1) {
                next.next = new ListNode();
                next = next.next;
            }
        }
        return resHead;
    }
}
