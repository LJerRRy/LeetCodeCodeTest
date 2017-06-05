package top.wenjiewang.job.offer;

import java.util.Set;

/**
 * Created by Jerry on 2017/4/28.
 */
public class Test1 {
    public boolean Find(int target, int [][] array) {
        if(array == null||array.length==0||array[0].length==0)return false;
        if(array[0][0]>target||array[array.length-1][array[0].length-1]<target)return false;
        int column1 = binarySearch(array[0],0,array[0].length-1,target);
        int column2 = binarySearch(array[array.length-1],0,array[0].length-1,target);
        column2 = column2>0?column2:0;
        System.out.println(column1+" "+column2);
//        if(array[0][column]==target)return true;
        int row = binarySearch2(array, column2, column1, 0, array.length-1,target);
        if(row<0)return false;
        return true;
    }
    public int binarySearch(int[] a, int lo ,int hi, int target){
        while(lo<=hi){
            int mid = lo + (hi - lo) / 2;
            if(a[mid] > target){
                hi = mid - 1;
            }else if(a[mid] < target){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return hi;
    }

    public int binarySearch2(int[][] a, int column1, int column2, int low ,int high, int target){
        System.out.println(column1 + " " + column2);
        for (int i = column1; i <= column2; i++) {
            int lo = low,hi=high;
            while(lo<=hi){
                int mid = lo + (hi - lo) / 2;
                if(a[mid][i] > target){
                    hi = mid - 1;
                }else if(a[mid][i] < target){
                    lo = mid + 1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }

    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)return null;
        RandomListNode p = copyDouble(pHead);
        p = copyRandom(p);
        return deleteOrignal(p);
    }

    private RandomListNode deleteOrignal(RandomListNode h){
//        RandomListNode p = h.next, head = h.next, q = head;
//        if(p.next==null)return head;
//        p = p.next.next;
//        while (p!=null){
//            RandomListNode r = p.next;
//            q.next = p;
//            q = p;
//            if(r!=null)p = r.next;
//            else p = null;
//        }
//        q.next = null;
//        return head;
        RandomListNode head = h.next, cur = head, p = h;
        while (p!=null){
            p.next = p.next.next;
            if(cur.next!=null){
                cur.next = cur.next.next;
            }
            cur = cur.next;
            p = p.next;
        }
        return  head;
    }

    private RandomListNode copyRandom(RandomListNode h){
        RandomListNode p1 = h, p2 = h.next;
        while(true){
            if (p1.random!=null) {
                p2.random = p1.random.next;
            }
            p1 = p2.next;
            if(p1==null) {
                break;
            }
            p2 = p1.next;
        }
        return h;
    }

    private RandomListNode copyDouble(RandomListNode h){
        RandomListNode p = h;
        while (p!=null){
            RandomListNode t = new RandomListNode(p.label);
            t.next = p.next;
            p.next = t;
            p = t.next;
        }
        return h;
    }

    private RandomListNode createRLN(int[] a){
        RandomListNode head = null, p =null;
        for (int i = 0; i < a.length/2; i++) {
            if(i==0){
                head = new RandomListNode(a[i]);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}
        };
        Test1 t = new Test1();
        System.out.println(t.Find(5,a));
//        Set<Integer>
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
