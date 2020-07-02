package algorithm.linear.stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    Node head;
    int N;

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator{

        private Node n;
        Itr(){
            this.n=head;
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
    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }
    public void push(T t){
        Node oldFirst = head.next;
        head.next = new Node(t, oldFirst);
        N++;
    }

    public T pop(){
        Node n = head.next;
        if(n == null){
            return null;
        }
        head.next = n.next;
        N--;
        return n.item;
    }

}
