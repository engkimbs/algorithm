package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l1Next = l1;
        l1Next.next = new ListNode(9);
        l1Next = l1Next.next;
        l1Next.next = new ListNode(9);
        l1Next = l1Next.next;
        l1Next.next = new ListNode(9);
        l1Next = l1Next.next;
        l1Next.next = new ListNode(9);
        l1Next = l1Next.next;
        l1Next.next = new ListNode(9);
        l1Next = l1Next.next;
        l1Next.next = new ListNode(9);
        l1Next = l1Next.next;

        ListNode l2 = new ListNode(9);
        ListNode l2Next = l2;
        l2Next.next = new ListNode(9);
        l2Next = l2Next.next;
        l2Next.next = new ListNode(9);
        l2Next = l2Next.next;
        l2Next.next = new ListNode(9);
        l2Next = l2Next.next;

        ListNode result = addTwoNumbers(l1, l2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next = null;
        boolean isUp = false;
        while(l1 != null || l2 != null) {
            int val1=0, val2=0;
            if(l1 != null) {
                val1 = l1.val;
                 l1 = l1.next;
            }
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = isUp ? val1 + val2 + 1 : val1 + val2;
            isUp = sum >= 10;
            if(result == null) {
                result = new ListNode();
                result.val = sum % 10;
                next = result;
            } else {
                next.next = new ListNode();
                next.next.val = sum % 10;
                next = next.next;
            }
        }

        if(isUp) {
            next.next = new ListNode();
            next.next.val = 1;
        }


        return result;
    }
}