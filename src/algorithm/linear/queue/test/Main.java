package algorithm.linear.queue.test;

import algorithm.linear.queue.Queue;


public class Main {
    public static void main(String[] args){
        Queue<String> queue = new Queue<>();
        queue.enqueue("你好");
        queue.enqueue("帅达");
        queue.enqueue("欣欣达子");
        queue.enqueue("CindaCoco");
        for(String item:queue){
            System.out.println(item);
        }
        String result = queue.dequeue();
        System.out.println("出队列的元素是："+result);
        System.out.println("现在队列的大小为："+queue.size());
    }
}
