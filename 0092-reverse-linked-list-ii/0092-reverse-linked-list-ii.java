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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode t = head;
        ListNode bef = null;
        int pos =1;
        while(t!=null){
            if(pos <left){
                pos++;
                bef = t;
                t=t.next;
                continue;
            }
            break;
            }
            ListNode curr = t;
            ListNode prev = null;
            int times = right-left+1;
            while(times-->0){
                ListNode next = curr.next;
                curr.next= prev;
                prev = curr;
                curr = next;
            }
            t.next = curr;
            if(bef!=null){
                bef.next = prev;
                return head;
            }
            return prev;
        }
    
}