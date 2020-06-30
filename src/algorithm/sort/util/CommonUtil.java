package algorithm.sort.util;

public class CommonUtil {
    public static boolean greater(Comparable a, Comparable b){
        return a.compareTo(b)>0;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    public static boolean equal(Comparable a, Comparable b){
        return a.compareTo(b) == 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
