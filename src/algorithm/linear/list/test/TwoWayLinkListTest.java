package algorithm.linear.list.test;

import algorithm.linear.list.TwoWayLinkList;

/**
 * java中的LinkList集合使用双向链表实现
 */
public class TwoWayLinkListTest {
    public static void main(String[] args){
        TwoWayLinkList<String> strings = new TwoWayLinkList<>();
        strings.insert("可欣");
        strings.insert("阿达");
        strings.insert("最好看");
        strings.insert(1, "啦啦啦");
        for(String s:strings){
            System.out.println(s);
        }
        String result = strings.remove(3);
        System.out.println("删除的结果是：" + result);

        for (String s:strings){
            System.out.println(s);
        }

        String first = strings.getFirst();
        String last = strings.getLast();
        System.out.println("第一个元素是"+first);
        System.out.println("最后一个元素是"+last);
    }
}
