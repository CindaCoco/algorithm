package algorithm.sort;

import algorithm.sort.util.CommonUtil;

/**
 * 快速排序也是高级排序算法中的一种
 * O(n*log(n))
 * 不稳定排序算法
 */
public class Quick {

    public static void sort(Comparable[] a){
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }

    public static void sort(Comparable[] a,int lo,int hi){
        if(hi<lo){
            return;
        }

        int partition = partition(a, lo, hi);

        sort(a,lo,partition-1);
        sort(a,partition+1,hi);
    }


    public static int partition(Comparable[] a,int lo,int hi){
        //确定分解值
        Comparable key = a[lo];

        int left = lo;
        int right = hi+1;

        while(true){
            //先从右往左扫描，找到一个比分界值小的值
            while (CommonUtil.less(key, a[--right])){
                if(right == lo){
                    break;
                }
            }
            //再从左往右扫描，找到一个比分界值大的值
            while (CommonUtil.less(a[++left], key)){
                if(left == hi){
                    break;
                }
            }
            //判断left是否等于right
            if(left>=right){
                break;
            }else {
                CommonUtil.exch(a, left, right);
            }
        }

        CommonUtil.exch(a, lo, right);
        return right;


    }
}
