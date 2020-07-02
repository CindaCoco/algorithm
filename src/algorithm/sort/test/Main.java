package algorithm.sort.test;

import algorithm.sort.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Integer[] a={5,7,6,11,2,8,94,23,45};
//        Bubble.sort(a);
//        Selection.sort(a);
//        Insertion.sort(a);
//        Shell.sort(a);
//        Merge.sort(a);
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
