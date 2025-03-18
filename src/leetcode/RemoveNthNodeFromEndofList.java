package leetcode;

public class RemoveNthNodeFromEndofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head;
        ListNode[] arr = new ListNode[31];
        int i = 0;
        while (next != null) {
            i++;
            arr[i] = next;
            next = next.next;
        }
        if (i == n && i == 1 )
            head = null;
        else if (i == n && i > 1)
            head = arr[2];
        else
            arr[i - n].next = arr[i - n + 2];
        return head;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode init(int[] arr) {
        ListNode resHead = new ListNode();
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


    public static void main(String[] args) {
        print(removeNthFromEnd(init(new int[]{1, 2, 3, 4, 5}), 2));
        print(removeNthFromEnd(init(new int[]{1}), 1));
        print(removeNthFromEnd(init(new int[]{1,2}), 1));
        print(removeNthFromEnd(init(new int[]{1, 2}), 2));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
