package algorithm.tree.test;

import algorithm.linear.queue.Queue;
import algorithm.tree.BinaryTree;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer,String> binaryTree = new BinaryTree<>();
        binaryTree.put(6, "张三");
        binaryTree.put(7,"李四");
        binaryTree.put(4,"帅达");
        binaryTree.put(5, "可欣");
        binaryTree.put(3, "王五");
        System.out.println("插入完成后元素的个数是："+binaryTree.size());

        System.out.println("键2对应的元素是："+binaryTree.get(2));
        binaryTree.delete(3);
        System.out.println("删除后的元素个数是："+binaryTree.size());
        System.out.println("删除后键3对应的元素是："+binaryTree.get(3));
//        binaryTree.delete(4);


        Queue<Integer> keys1 = binaryTree.preErgodic();
        System.out.println("前序遍历结果：");
        for(int k:keys1){
            System.out.print(k+"  ");
        }
        System.out.println();

        Queue<Integer> keys2 = binaryTree.midErgodic();
        System.out.println("中序遍历结果：");
        for(int k:keys2){
            System.out.print(k+"  ");
        }
        System.out.println();

        Queue<Integer> keys3 = binaryTree.afterErgodic();
        System.out.println("后序遍历结果：");
        for(int k:keys3){
            System.out.print(k+"  ");
        }
        System.out.println();

        Queue<Integer> keys4 = binaryTree.layerErgodic();
        System.out.println("层序遍历结果：");
        for(int k:keys4){
            System.out.print(k+"  ");
        }
        System.out.println();

        System.out.println("树的深度为："+binaryTree.maxDepth());

    }
}
