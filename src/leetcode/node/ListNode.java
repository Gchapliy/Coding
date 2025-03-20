package leetcode.node;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
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