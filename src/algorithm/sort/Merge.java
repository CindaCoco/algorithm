package algorithm.sort;

import algorithm.sort.util.CommonUtil;

/**
 * 属于高级排序算法中的一种
 * O（n*log(n)）
 *  稳定排序算法
 */
public class Merge {
    private static Comparable[] assist;

    public static void sort(Comparable[] a){
        //初始化辅助数组
        assist = new Comparable[a.length];
        int lo=0;
        int hi=a.length-1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        //安全性校验
        if(hi<=lo){
            return ;
        }
        //分组
        int mid = lo+(hi-lo)/2;

        //分别对每一组进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);

        //归并

        merge(a,lo,mid,hi);
    }

    private static void merge(Comparable[] a,int lo, int mid,int hi){
        int p1=lo;
        int p2=mid+1;
        int i=lo;


        while(p1 <= mid && p2<=hi){
            if(CommonUtil.less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else{
                assist[i++] = a[p2++];
            }
        }

        while (p1<=mid){
            assist[i++] = a[p1++];
        }

        while (p2<=hi){
            assist[i++] = a[p2++];
        }

        if (hi + 1 - lo >= 0) System.arraycopy(assist, lo, a, lo, hi + 1 - lo);
    }
}
