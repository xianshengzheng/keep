package linked;

import utils.ListNode;

/**
 * @Author ZhengH
 * @Date 2019/12/5 10:29
 * 141 反转链表
 **/
public class Reversal {
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode newNode = null;
        while (secondNode != null) {
            ListNode newHead = firstNode;
            firstNode = secondNode;
            secondNode = secondNode.next;

            newHead.next = newNode;
            newNode = newHead;
        }
        firstNode.next = newNode;
        return firstNode;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNodes();
        Reversal reversal = new Reversal();
        ListNode listNode1 = reversal.reverseList2(listNode);
        System.out.println(listNode1);
    }
}
