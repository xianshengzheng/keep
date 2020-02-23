package linked;

import utils.ListNode;

/**
 * @Author ZhengH
 * @Date 2019/12/9 14:33
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 **/
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode one = first;
        ListNode two = head;
        while (n != 0) {
            two = two.next;
            n--;
        }
        while (two != null) {
            two = two.next;
            one = one.next;
        }
        one.next = one.next.next;
        return first.next;
    }

    public static void main(String[] args) {
        ListNode listNodes = ListNode.getListNodes();
        removeNthFromEnd(listNodes, 2);
    }
}
