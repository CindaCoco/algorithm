package algorithm.heap;

public class HeapSort<T extends Comparable<T>> {
    public static void sort(Comparable[] source){
        Comparable[] heap = new Comparable[source.length+1];
        createHeap(heap,source);
        int N = heap.length-1;
        while(N!=1){
            exchange(heap, 1, N);
            N--;
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source, 0,source.length);

    }

    private static void createHeap(Comparable[] heap, Comparable[] source){
        //拷贝，无序的
        System.arraycopy(source,0,heap,1,source.length);

        for(int i = (heap.length/2);i>0;i--){
            sink(heap,i, heap.length-1);
        }
    }

    private static boolean less(Comparable[] heap,int i, int j){
        return heap[i].compareTo(heap[j])<0;
    }

    private static void exchange(Comparable[] heap,int i,int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    private static void sink(Comparable[] heap, int k, int N){
        while (2*k<=N){
            int max;
            if(2*k+1<=N){
                if(less(heap,2*k,2*k+1)) {
                    max = 2 * k + 1;
                }else {
                    max = 2*k;
                }
            }else {
                max = 2*k;
            }
            if(!less(heap,k,max)){
                break;
            }
            exchange(heap,k, max);
            k = max;
        }
    }


}
