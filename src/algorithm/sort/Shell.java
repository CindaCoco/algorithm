package algorithm.sort;

import algorithm.sort.util.CommonUtil;

/**
 * 属于高级排序算法中的一种
 * 希尔排序是对插入排序的升级
 * O(n^(1.3-2))
 * 不稳定排序算法
 */
public class Shell {
    public static void sort(Comparable[] a){
        //根据数组长度确定增长量h，希尔排序根据h对数据进行分组排序
        int h=1;
        while(h<a.length/2){
            h = 2*h+1;
        }
        while(h>=1){
            //排序
            for(int i=h;i<a.length;i++){
                for(int j=i;j>=h;j-=h){
                    if(CommonUtil.greater(a[j-h],a[j])){
                        CommonUtil.exch(a,j,j-h);
                    }else {
                        break;
                    }
                }
            }
            //减小h的值
            h=h/2;
        }
    }
}
