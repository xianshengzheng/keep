package linked;

import utils.ListNode;

/**
 * @Author ZhengH
 * @Date 2019/12/9 14:12
 * 21 合并两个有序列表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 **/
public class MergeTwoLists {
    public ListNode myMergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode newList = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newList.next = l1;
                l1 = l1.next;
                newList = newList.next;
            }else {
                newList.next = l2;
                l2 = l2.next;
                newList = newList.next;
            }
        }
        newList.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

    /**
     * 递归思想
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }



}
