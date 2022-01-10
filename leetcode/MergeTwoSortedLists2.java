public class MergeTwoSortedLists2 {

    public MergeTwoSortedLists.ListNode mergeTwoLists(MergeTwoSortedLists.ListNode l1, MergeTwoSortedLists.ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        MergeTwoSortedLists.ListNode prehead = new MergeTwoSortedLists.ListNode(-1);

        MergeTwoSortedLists.ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
