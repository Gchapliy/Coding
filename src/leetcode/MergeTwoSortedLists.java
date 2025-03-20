package leetcode;

import leetcode.node.ListNode;
import static leetcode.node.ListNodeInitiator.init;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = list1 != null || list2 != null ? new ListNode() : null;
        ListNode target = head;

        while (true) {
            if(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    target.val = list1.val;
                    list1 = list1.next;
                } else if (list2.val < list1.val){
                    target.val = list2.val;
                    list2 = list2.next;
                }
                target = target.next = list1 != null || list2 != null? new ListNode() : null;
            } else if (list1 == null && list2 != null) {
                target.val = list2.val;
                target = target.next = list2.next != null ? list2.next : null;
                list2 = list2.next;
            } else if (list1 != null && list2 == null) {
                target.val = list1.val;
                target = target.next = list1.next != null ? list1.next : null;
                list1 = list1.next;
            } else {
                break;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        print(mergeTwoLists(init(new int[]{1,2,4}), init(new int[]{1,3,4})));
        print(mergeTwoLists(init(new int[]{}), init(new int[]{})));
        print(mergeTwoLists(init(new int[]{}), init(new int[]{0})));
        print(mergeTwoLists(init(new int[]{5}), init(new int[]{1,2,4})));
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
