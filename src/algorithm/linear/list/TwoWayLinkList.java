package algorithm.linear.list;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T> {
    Node head;
    Node last;
    int N;

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator{

        private Node n;
        public Itr(){
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
        Node pre;
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TwoWayLinkList(){
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    public void clear(){
        head.next = null;
        this.last = null;
        this.N = 0;
    }

    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    public void insert(T t){
        //链表为空
        if(isEmpty()) {
            Node newNode = new Node(t, head, null);
            this.last = newNode;
            head.next = newNode;
        }else {
            Node newNode = new Node(t, last, null);
            last.next = newNode;
            last = newNode;
        }
        N++;
    }

    public void insert(int i, T t){
        //找到i位置的前一个结点
        Node pre = head;
        for(int index=0;index<i;index++){
            pre = pre.next;
        }
        Node curr = pre.next;

        Node newNode = new Node(t, pre, curr);
        pre.next = newNode;
        newNode.next = curr;
        N++;
    }

    public T get(int i){
        Node n = head.next;
        for(int index=0;index<i;index++){
            n = n.next;
        }
        return n.item;
    }

    public int indexOf(T t){
        Node n = head;
        for(int i=0;n.next!=null;i++){
            n = n.next;
            if(n.next.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    public T remove(int i){
        Node pre = head;
        for(int index=0;index<i;index++){
            pre = pre.next;
        }

        Node curr = pre.next;

        Node nextNode = curr.next;

        pre.next = nextNode;
        if(nextNode!=null){
            nextNode.pre = pre;
        }else {
            last=pre;
        }
        N--;
        return curr.item;
    }


}
