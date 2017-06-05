package top.wenjiewang.leetcode1_20;

/**
 * Created by Jerry on 2016/8/21.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x){
        val = x;
    }
}
public class AddTwoNum2 {
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode lhead;
        ListNode l3=new ListNode(0);
        lhead=l3;
        if(l1==null&&l2==null)
            return null;
        int flag=0;
        while (l1!=null||l2!=null){
            ListNode lnext = new ListNode(0);
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            lnext.val=(a+b+flag)%10;
            flag=(a+b+flag)/10;
            l3.next=lnext;
            l3=l3.next;
            l1 = l1==null?null:l1.next;//careful
            l2 = l2==null?null:l2.next;
        }
        if(flag!=0){
            ListNode s = new ListNode(0);
            s.val=flag;
            l3.next=s;
        }
        return lhead.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(0);
        l1.next=new ListNode(8);
//        l1.next.next=new ListNode(3);
//        l2.next=new ListNode(6);
//        l2.next.next=new ListNode(4);
        ListNode l3 = addTwoNumbers(l1,l2);
        while (l3 != null){
            System.out.print(l3.val + "->");
            l3=l3.next;
        }
    }
}
