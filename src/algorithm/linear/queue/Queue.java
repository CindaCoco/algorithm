package algorithm.linear.queue;

import java.util.Iterator;

/**
 * 从头出从尾进 head->first->second->third    <==last
 * @param <T>
 */
public class Queue<T> implements Iterable<T>{

    private Node head;
    private Node last;

    private int N;

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator{
        Node n;
        Itr(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    private class Node{
        T item;
        Node next;
        Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }
    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(T t){
        if(last == null){
            last = new Node(t, null);
            head.next = last;
        }else{
            last.next = new Node(t, null);
            last = last.next;
        }
        N++;
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;

        if(isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

}
