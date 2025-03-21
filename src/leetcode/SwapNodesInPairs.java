package leetcode;

import leetcode.node.ListNode;

import static leetcode.node.ListNodeInitiator.init;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        System.out.println(swapPairs(init(new int[]{1, 2, 3, 4})));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
}
