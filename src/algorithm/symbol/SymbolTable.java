package algorithm.symbol;

public class SymbolTable<Key, Value> {
    Node head;
    int N;

    private class Node{
        Key key;
        Value value;
        Node next;
        Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public int size(){
        return N;
    }



    public void put(Key key,Value value){
        //1、存在key
        Node n = head;
        while (n.next!=null){
            n = n.next;
            if(n.key.equals(key)){
                n.value = value;
                return;
            }
        }




        //2、不存在key
        head.next = new Node(key, value, head.next);
        N++;
    }

    public void delete(Key key){
        Node n = head;
        while (n.next!=null){
            if(n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value get(Key key){
        Node n = head;
        while (n.next!=null){
            if(n.next.key.equals(key)){
                return n.next.value;
            }
            n = n .next;
        }
        return null;
    }
}
