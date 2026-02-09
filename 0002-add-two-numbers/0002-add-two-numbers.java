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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper (l1, l2, 0);
    }
    private ListNode helper(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int val1 = (l1 != null) ? l1.val:0;
        int val2 = (l2 != null) ? l2.val:0;
        int sum = val1 + val2 + carry;

        int newDigit = sum % 10;
        int newCarry = sum / 10;

        ListNode currentNode = new ListNode(newDigit);

        ListNode next1 = (l1 != null) ? l1.next:null;
        ListNode next2 = (l2 != null) ? l2.next:null;

        currentNode.next = helper(next1, next2, newCarry);
        
        return currentNode;

    }
}