package le;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class le_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nodeA = l1;
        ListNode nodeB = l2;
        ListNode nodeResult = new ListNode(-1);
        ListNode nodePro = nodeResult;
        int upNum = 0;

        while (nodeA != null || nodeB != null) {
            int a = 0, b = 0;
            if (nodeA != null) {
                a = nodeA.val;
                nodeA = nodeA.next;
            }
            if (nodeB != null) {
                b = nodeB.val;
                nodeB = nodeB.next;
            }
            int result = a + b + upNum;
            upNum = result >= 10 ? 1 : 0;
            nodePro.next = new ListNode(upNum % 10);
            nodePro = nodePro.next;
        }
        if(upNum == 1){
            nodePro.next = new ListNode(1);
        }

        return nodeResult.next;
    }
}



