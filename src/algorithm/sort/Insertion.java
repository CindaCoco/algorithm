package algorithm.sort;

import algorithm.sort.util.CommonUtil;

/**
 * 稳定排序算法
 */
public class Insertion {
    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(CommonUtil.greater(a[j-1],a[j])){
                    CommonUtil.exch(a,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
}
