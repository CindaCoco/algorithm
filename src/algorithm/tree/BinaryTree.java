package algorithm.tree;

import algorithm.linear.queue.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value> {

    private Node root;
    private int N;

    public BinaryTree() {
        root = null;
        N = 0;
    }

    private class Node{
        public Node left;
        public Node right;
        public Key key;
        public Value value;

        public Node(Node left, Node right, Key key, Value value) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }

    }
    public int size(){
        return N;
    }

    public void put(Key key,Value value){
        root = put(root, key, value);
    }

    /**
     * 向指定的树x中添加key-value，并返回添加新元素后的树
     * @param x 树
     * @param key 键
     * @param value 值
     * @return 新的树
     */
    public Node put(Node x,Key key,Value value){
        //如果x子树为空
        if(x == null){
            N++;
            return new Node(null,null,key,value);
        }
        //如果x子树不为空
        //比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);
        //如果key小于结点的键；则继续寻找x的左子树
        if(cmp<0){
            x.left = put(x.left,key,value);
        }else if(cmp>0){

            //如果key大于结点的键；则继续寻找x的右子树
            x.right = put(x.right, key, value);
        }else{
            //相等
            x.value = value;
        }
        return x;
    }

    public Value get(Key key){
        return get(root, key);
    }

    public Value get(Node x,Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        //如果key小于结点的键；则继续寻找x的左子树
        if(cmp<0){
            return get(x.left, key);
        }else if(cmp>0){
            //如果key大于结点的键；则继续寻找x的右子树
            return get(x.right, key);
        }else{
            return x.value;
        }
    }

    public void delete(Key key){
        delete(root, key);
    }

    public Node delete(Node x,Key key){
        //x树为null
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            //如果key小于结点的键；则继续寻找x的左子树
            x.left = delete(x.left,key);
        }else if(cmp>0){
            //如果key大于结点的键；则继续寻找x的右子树
            x.right = delete(x.right,key);
        }else{
            N--;
            if(x.right == null){
                return x.left;
            }
            if(x.left == null){
                return x.right;
            }
            //找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left!=null){
                minNode = minNode.left;
            }
            //删除与最小结点的连接
            Node n = x.right;
            while(n.left!=null){
                if(n.left.left==null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }

            //让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minNode;

        }
        return x;
    }

    //查找整棵树中最小的键
    public Key min(){
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left!=null){
            return min(x.left);
        }else {
            return x;
        }
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right!=null){
            return max(x.right);
        }else {
            return x;
        }
    }
    //前序遍历
    public Queue<Key> preErgodic(){
        Queue<Key> queue = new Queue<>();
        preErgodic(root, queue);
        return queue;
    }

    private void preErgodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }
        keys.enqueue(x.key);
        if(x.left!=null){
            preErgodic(x.left, keys);
        }
        if(x.right!=null){
            preErgodic(x.right, keys);
        }
    }

    public Queue<Key> midErgodic(){
        Queue<Key> queue = new Queue<>();
        midErgodic(root, queue);
        return queue;
    }

    private void midErgodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }
        if(x.left!=null){
            midErgodic(x.left, keys);
        }
        keys.enqueue(x.key);
        if(x.right!=null){
            midErgodic(x.right, keys);
        }
    }

    public Queue<Key> afterErgodic(){
        Queue<Key> queue = new Queue<>();
        afterErgodic(root, queue);
        return queue;
    }

    private void afterErgodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }

        if(x.left!=null){
            afterErgodic(x.left, keys);
        }
        if(x.right!=null){
            afterErgodic(x.right, keys);
        }
        keys.enqueue(x.key);
    }

    public Queue<Key> layerErgodic(){

        //需要一个额外的辅助队列
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认放入根节点
        nodes.enqueue(root);

        while (!nodes.isEmpty()){
            //从队列中弹出结点，并将key值放入keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            if(n.left!=null){
                nodes.enqueue(n.left);
            }
            if(n.right!=null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }


    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(Node x){
        if(x == null){
            return 0;
        }
        int maxL = 0;
        int maxR = 0;
        if(x.left!=null){
            maxL = maxDepth(x.left);
        }
        if(x.right!=null){
            maxR = maxDepth(x.right);
        }
        return Math.max(maxL+1,maxR+1);
    }
}
