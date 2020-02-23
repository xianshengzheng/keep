package linked;

import utils.ListNode;

/**
 * @Author ZhengH
 * @Date 2019/12/5 11:11
 * 206 有环返回true没有返回false
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode prev = head;
        ListNode next = head;
        while (next.next != null && next.next.next !=null){
            next = next.next.next;
            prev = prev.next;
            if(next == prev){
                return true;
            }
        }
        return false;
    }
}
