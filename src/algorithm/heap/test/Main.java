package algorithm.heap.test;

import algorithm.heap.Heap;
import algorithm.heap.HeapSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(1);
        heap.insert(7);
        heap.insert(6);
        heap.insert(4);
        heap.insert(5);

        Integer result;
        while ((result = heap.delMax()) != null){
            System.out.println(result+" ");
        }


        Integer[] a = {1,4,9,8,3,5,7};
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
