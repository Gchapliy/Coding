package leetcode;

import leetcode.node.ListNode;

import static leetcode.node.ListNodeInitiator.init;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        System.out.println(reverseKGroup(init(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(reverseKGroup(init(new int[]{1, 2, 3, 4, 5}), 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        ListNode curr = head;
        ListNode prev = null;
        int cnt = 0;

        while(t != null && cnt < k)
        {
            t = t.next;
            cnt++;
        }
        if(cnt < k)
        {
            return head;
        }
        for(int i=k; i>0; i--)
        {
            t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;

        }
        head.next = reverseKGroup(curr,k);

        return prev;
    }
}
