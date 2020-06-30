package algorithm.sort;

import algorithm.sort.util.CommonUtil;

/**
 * 不稳定排序算法
 */
public class Selection {

    public static void sort(Comparable[] a){
        int min;
        for(int i=0;i<a.length-1;i++){
            min=i;
            for(int j=i;j<a.length;j++){
                if(CommonUtil.greater(a[min], a[j])){
                    min=j;
                }
            }
            CommonUtil.exch(a, min, i);
        }
    }
}
