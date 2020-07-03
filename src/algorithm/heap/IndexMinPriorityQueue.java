package algorithm.heap;

import java.util.Arrays;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    //保存每个元素在items数组中的索引,pq数组需要堆有序
    private int[] pq;
    //保存pq的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;
    private int N;

    public IndexMinPriorityQueue(int capacity){
        this.items = (T[])new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;

        //默认情况下，队列中无元素，让qp中的元素都为-1
        Arrays.fill(qp, -1);
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }
    private void exchange(int i,int j){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        //更新qp
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public boolean contains(int k){
        return qp[k] != -1;
    }

    public int minIndex(){
        return pq[1];
    }

    public void insert(int i,T t){
        if(contains(i)){
            return;
        }
        N++;
        items[i] = t;
        pq[N] = i;
        qp[i] = N;
        swim(N);
    }

    public int delMin(){
        int minIndex = minIndex();

        exchange(1, N);
        items[minIndex] = null;
        qp[pq[N]] = -1;
        pq[N] = -1;
        N--;
        sink(1);
        return minIndex;
    }

    public void delete(int i){
        int k = qp[i];

        exchange(k, N);

        qp[pq[N]] = -1;
        pq[N] = -1;
        items[k] = null;
        N--;
        sink(k);
        swim(k);
    }

    public void changeItem(int i, T t){
        items[i] = t;
        int k = qp[i];
        sink(k);
        swim(k);
    }

    public void swim(int k){
        while (k>1){
            if(less(k,k/2)){
                exchange(k, k/2);
            }
            k /= 2;
        }
    }

    public void sink(int k){
        while(2*k<=N){
            int min;
            if(2*k+1<=N){
                if(less(2*k,2*k+1)){
                    min = 2*k;
                }else {
                    min = 2*k+1;
                }
            }else {
                min = 2*k;
            }
            if(less(k,min)){
                break;
            }
            exchange(k,min);
            k = min;
        }
    }


}
