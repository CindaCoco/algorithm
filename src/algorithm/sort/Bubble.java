package algorithm.sort;

import algorithm.sort.util.CommonUtil;

/**
 * 稳定排序算法
 */
public class Bubble {

    public static void sort(Comparable[] a){
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(CommonUtil.greater(a[j], a[j+1])){
                    CommonUtil.exch(a, j, j+1);
                }
            }
        }
    }


}
