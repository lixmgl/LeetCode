public class SortList {
    public static void main(String[]args){
      SortList sl=new SortList();
      ListNode list=new ListNode(3);
      list.next=new ListNode(1);
      list.next.next=new ListNode(2);
      list.next.next.next=new ListNode(0);
      list.next.next.next.next=new ListNode(-1);
      list.next.next.next.next.next=new ListNode(4);
      ListNode result=sl.sortList(list);
      while(result.next!=null){
        System.out.println(result.val);
        result=result.next;
      }
    }

    //mergeSort: remember to do the recursion part! Cannot just merge from the middle.
    //have to make sure both parts are already sorted.
    //pre.next=null, separate the first half list!
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(slow);
        return merge(firstHalf, secondHalf);
    }

    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {
        ListNode dummy = new ListNode(-1);
        ListNode crt = dummy;
        while(firstHalf != null && secondHalf != null) {
            if (firstHalf.val < secondHalf.val) {
                crt.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                crt.next = secondHalf;
                secondHalf = secondHalf.next;
            }

            crt = crt.next;
        }

        if (firstHalf != null)
            crt.next = firstHalf;
        else
            crt.next = secondHalf;

        return dummy.next;
    }
}


//quick sort
//use head node as pivot, all nodes smaller than pivot as left list, larger as right list.
//combine: left->pivot->right, pay attention to the combination points.
public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode pivot = head;
            ListNode left = new ListNode(-1);
            ListNode right = new ListNode(-1);
            ListNode leftHead = left;
            ListNode rightHead = right;
            ListNode pivotHead = pivot;
            ListNode crt = head.next;
            if (crt == null)
                return pivot;

            while(crt != null) {
                if (crt.val < pivot.val) {
                    left.next = crt;
                    left = left.next;
                } else if (crt.val > pivot.val){
                    right.next = crt;
                    right = right.next;
                } else {
                    pivot.next = crt;
                    pivot = pivot.next;
                }
                crt = crt.next;
            }

            pivot.next = null;
            left.next = null;
            right.next = null;
            left = sortList(leftHead.next);
            right = sortList(rightHead.next);
            pivot.next = right;
            ListNode re = left;

            while (left != null && left.next != null) {
                left = left.next;
            }

            if (left == null) 
                re = pivotHead;
            else 
                left.next = pivotHead;
            return re;
        }