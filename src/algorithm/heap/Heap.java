package algorithm.heap;

public class Heap<T extends Comparable<T>> {

    private T[] items;
    private int N;


    public Heap(int capacity){
        this.items = (T[])new Comparable[capacity+1];
        this.N = 0;
    }

    private boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }

    private void  exchange(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //废弃0索引
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    public void swim(int k){
        while (k>1){
            if(less(k/2, k)){
                exchange(k/2, k);
                k = k/2;
            }else{
                break;
            }
        }
    }


    public T delMax(){
        T max = items[1];
        exchange(1,N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    public void sink(int k){
        //通过循环不断对比当前结点和其左节点2*k以及右节点2*k+1中的较大值交换位置
        while (2*k<=N){
            int max;
            if(2*k+1<=N){
                if(less(2*k,2*k+1)) {
                    max = 2 * k + 1;
                }else {
                    max = 2*k;
                }
            }else {
                max = 2*k;
            }
            if(!less(k,max)){
                break;
            }

            exchange(k, max);

            k = max;
        }
    }


}
