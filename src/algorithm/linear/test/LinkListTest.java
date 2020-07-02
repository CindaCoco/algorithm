package algorithm.linear.test;

import algorithm.linear.LinkList;

public class LinkListTest {
    public static void main(String[] args){
        LinkList<String> strings = new LinkList<>();
        strings.insert("可欣");
        strings.insert("阿达");
        strings.insert("最好看");
        strings.insert(1, "啦啦啦");
        String result = strings.remove(3);
        System.out.println("删除的结果是：" + result);

        for (String s:strings){
            System.out.println(s);
        }
        strings.reverse();
        for(String s:strings){
            System.out.println(s);
        }
    }
}
