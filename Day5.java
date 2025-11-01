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
    public ListNode modifiedList(int[] nums, ListNode head) {
        
       Set<Integer> removeset=new HashSet<>();
       for(int x:nums){
        removeset.add(x);
       }
       ListNode dummy=new ListNode(0,head);
       ListNode prev=dummy;
       while(prev.next!=null){
        if(removeset.contains(prev.next.val)){
            prev.next = prev.next.next;
        }
        else prev = prev.next;
       }

        return dummy.next;
    }
}
public class Day5-3217 {
    
}
