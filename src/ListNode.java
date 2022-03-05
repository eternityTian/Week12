class ListNode {
    int val;//链表中节点的值
    ListNode next; //引用

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 输入一个链表头节点，反转链表，输出反转后头节点
     *
     * @return
     */
    static ListNode test1(ListNode ln) {
        if (ln == null || ln.next == null) return ln;
        ListNode temp = test1(ln.next);//temp拿到最后一个
        ln.next.next  = ln;//3-->1
        ln.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        System.out.println(test1(l1).val);
    }

}