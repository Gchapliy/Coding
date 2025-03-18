package leetcode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode first = res;
        int multy = 0;
        while (true) {
            if (l1 != null && l2 != null) {
                res.val = (l1.val + l2.val + multy) % 10;
                multy = (l1.val + l2.val + multy) / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                res.val = (l1.val + multy) % 10;
                multy = (l1.val + multy) / 10;
                l1 = l1.next;
            } else if (l2 != null) {
                res.val = (l2.val + multy) % 10;
                multy = (l2.val + multy) / 10;
                l2 = l2.next;
            } else {
                break;
            }
            res.next = l1 != null || l2 != null ? new ListNode() : multy > 0 ? new ListNode(multy) : null;
            res = res.next;
        }

        return first;
    }

    private static class ListNode {
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(Integer.toString(val));
            ListNode n = next;
            while (n != null) {
                sb.append("->").append(n.val);
                n = n.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(
                        new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(4)))
                )
        );
        System.out.println(addTwoNumbers(
                new ListNode(0),
                new ListNode(0)
        ));
        System.out.println(addTwoNumbers(
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))
                )
        );
    }
}
