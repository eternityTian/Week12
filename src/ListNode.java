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

    static ListNode test2(ListNode ln1, ListNode ln2) {
        if (ln1 == null && ln2 == null) return null;
        else if (ln1 == null) return ln2;
        else if (ln2 == null) return ln1;

        ListNode temp,res = null;
        if (ln1.val >= ln2.val) {
            res = ln2;
            ln2 = ln2.next;
        }else {
            res = ln1;
            ln1 = ln1.next;
        }
        temp = res;
        while (ln1 != null && ln2 != null) {
            if (ln1 == null) {
                res.next = ln2;
                ln2 = ln2.next;
                res = res.next;
                continue;
            }
            if (ln2 == null) {
                res.next = ln1;
                ln1 = ln1.next;
                res = res.next;
                continue;
            }

            if (ln1.val >= ln2.val) {
                res.next = ln2;
                ln2 = ln2.next;
            }else {
                res.next = ln1;
                ln1 = ln1.next;
            }
            res = res.next;
        }

        return temp;
    }

    static boolean test3(ListNode listNode) {
        int num = 0;
        ListNode listNodeTemp = listNode;
        ListNode l1,temp = new ListNode(listNodeTemp.val);
        l1 = temp;//copy原链表
        while (listNodeTemp.next != null) {
            listNodeTemp = listNodeTemp.next;
            temp.next = new ListNode(listNodeTemp.val);
            temp = temp.next;
        }
        ListNode l2 = test1(listNode);//得到反转链表

        while (l1.next!=null){
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }

    static void printList(ListNode listNode){
        while (listNode != null) {
            System.out.print(listNode.val);
            if (listNode.next != null) System.out.print("-->");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //第一题测试
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.print("原链表l:");
        printList(l1);
        System.out.println("反转后头节点值"+test1(l1).val);

        //第二题测试
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(17);
        l4.next = l5;
        l5.next = l6;
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("--------------------------");
        System.out.print("链表l:");
        printList(l4);
        System.out.print("链表n:");
        printList(n1);
        ListNode newNode = test2(l4, n1);
        System.out.print("合并后：");
        printList(newNode);

        //第三题
        System.out.println("--------------------------");
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        t1.next = t2;
        printList(t1);
        System.out.println(test3(t1));
        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(2);
        ListNode x3 = new ListNode(2);
        ListNode x4 = new ListNode(1);
        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        printList(x1);
        System.out.println(test3(x1));
    }

}