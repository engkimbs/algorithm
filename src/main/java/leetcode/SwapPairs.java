package leetcode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        ListNode p = head;
        ListNode next = p.next;
        ListNode prev = null;
        while(p.next != null) {
            ListNode nextOfNext = next.next;

            if(prev == null) {
                head = next;
            }

            next.next = p;
            p.next = nextOfNext;
            if(prev != null)
                prev.next = next;

            prev = p;
            p = nextOfNext;
            if(p == null)
                break;
            next = p.next;
        }
        return head;
    }
}
