package algorithm.symbol.test;

import algorithm.symbol.OrderSymbolTable;
import algorithm.symbol.SymbolTable;

public class Main {
    public static void main(String[] args) {
        SymbolTable<Integer, String>  symbolTable = new SymbolTable<>();
        symbolTable.put(1, "帅达");
        symbolTable.put(2,"可欣");
        symbolTable.put(3, "成双成对");

        System.out.println("插入完毕后，元素的个数为："+symbolTable.size());
        symbolTable.put(3, "终成眷属");
        System.out.println("替换后3对应的值为："+symbolTable.get(3));
        symbolTable.delete(1);
        System.out.println("删除后的个数为:"+symbolTable.size());


        OrderSymbolTable<Integer, String> orderSymbolTable = new OrderSymbolTable<>();
        orderSymbolTable.put(1,"a");
        orderSymbolTable.put(2,"b");
        orderSymbolTable.put(3,"e");
        orderSymbolTable.put(7, "hello");
        orderSymbolTable.put(5, "liu");
    }
}
