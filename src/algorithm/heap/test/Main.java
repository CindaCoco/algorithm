package algorithm.heap.test;

import algorithm.heap.*;

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


        MaxPriorityQueue<Integer> queue = new MaxPriorityQueue<>(10);
        queue.insert(6);
        queue.insert(8);
        queue.insert(2);
        queue.insert(10);
        queue.insert(1);

        while (!queue.isEmpty()){
            result = queue.delMax();
            System.out.print(result+" ");
        }
        System.out.println();


        MinPriorityQueue<Integer> minQueue = new MinPriorityQueue<>(10);
        minQueue.insert(2);
        minQueue.insert(7);
        minQueue.insert(5);
        minQueue.insert(6);

        while (!minQueue.isEmpty()){
            result = minQueue.delMin();
            System.out.print(result+" ");
        }

        System.out.println();


        IndexMinPriorityQueue<String> indexQueue = new IndexMinPriorityQueue<>(10);

        indexQueue.insert(0, "A");
        indexQueue.insert(1, "C");
        indexQueue.insert(2, "F");
        indexQueue.changeItem(2,"B");
        while (!indexQueue.isEmpty()){
            int index = indexQueue.delMin();
            System.out.print(index+" ");
        }
        System.out.println();
    }
}
