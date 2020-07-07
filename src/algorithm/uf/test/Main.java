package algorithm.uf.test;

import algorithm.uf.UF;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UF uf=new UF(5);
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("请输入第一个要合并的元素");
            int p = scanner.nextInt();
            System.out.println("请输入第二个要合并的元素");
            int q = scanner.nextInt();

            if(uf.connected(p,q)){
                System.out.println("两个元素已经在同一组中了");
                continue;
            }

            uf.union(p,q);
            System.out.println("当前的集合中还有"+uf.count()+"个分组");
        }
    }
}
