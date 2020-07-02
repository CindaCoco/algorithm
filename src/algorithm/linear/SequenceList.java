package algorithm.linear;

import java.util.Iterator;

/**
 * get O(1)
 * insert O(n)
 * remove O(n)
 * 这个跟java的ArrayList差不多
 * @param <T>
 */
public class SequenceList<T> implements Iterable<T>{
    // 存储元素的数据
    private T[] elements;
    // 记录当前顺序表中的元素个数
    private int N;

    public SequenceList(){
        int defaultSize = 10;
        this.elements = (T[]) new Object[defaultSize];
        this.N = 0;
    }

    public SequenceList(int capacity){
        this.elements = (T[]) new Object[capacity];
        this.N = 0;
    }

    public void clear(){
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        return elements[i];
    }

    public void insert(T t){
        if(N==elements.length){
            resize(2*elements.length);
        }

        this.elements[N++] = t;
    }

    public void insert(int i, T t){
        if(N==elements.length){
            resize(2*elements.length);
        }

        // 先把i索引及其后面的元素后移一位
        if (N - i >= 0) System.arraycopy(this.elements, i, this.elements, i + 1, N - i);
        N++;
        this.elements[i] = t;
    }

    public T remove(int i){
        T current = this.elements[i];
        if (N - 1 - i >= 0) System.arraycopy(this.elements, i + 1, this.elements, i, N - 1 - i);
        N--;
        if(N<elements.length/4){
            resize(elements.length/2);
        }
        return current;
    }


    public int indexOf(T t){
        for(int i = 0;i<N;i++){
            if(this.elements[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public void resize(int newSize){
        T[] temp = elements;
        elements = (T[])new Object[newSize];
        if (N >= 0) System.arraycopy(temp, 0, elements, 0, N);
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{

        private int cursor;
        public SIterator(){
            this.cursor=0;
        }
        @Override
        public boolean hasNext() {
            return cursor<N;
        }

        @Override
        public Object next() {
            return elements[cursor++];
        }
    }
}
