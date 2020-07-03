package algorithm.heap;

/**
 * 其实跟堆一模一样 就是多了个size和isEmpty
 * @param <T>
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public MinPriorityQueue(int capacity){
        this.items = (T[])new Comparable[capacity+1];
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    private boolean greater(int i, int j){
        return items[i].compareTo(items[j])>0;
    }
    private void exchange(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    public T delMin(){
        T min = items[1];
        exchange(1, N);
        N--;
        sink(1);
        return min;
    }

    private void swim(int k){
        while (k>1){
            if(greater(k/2,k)){
                exchange(k/2, k);
                k /= 2;
            }else {
                break;
            }
        }
    }

    private void sink(int k){
        while (2*k<=N){
            int min;
            if(2*k+1<=N){
                if(greater(2*k, 2*k+1)){
                    min = 2*k+1;
                }else{
                    min = 2*k;
                }
            }else {
                min = 2*k;
            }
            if(!greater(k,min)){
                break;
            }
            exchange(k,min);
            k = min;

        }
    }
}
