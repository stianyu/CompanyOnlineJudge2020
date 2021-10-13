package bigo;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        ListNode revHead = reverse(dummyHead.next);

        printListNode(revHead);
    }

    private static void printListNode(ListNode revHead) {
        ListNode cur = revHead;
        System.out.println("[");
        while (cur != null) {
            System.out.println(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("]");
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}

class ListNode{
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
