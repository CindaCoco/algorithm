package algorithm.linear.stack.test;

import algorithm.linear.stack.Stack;

public class Main {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for(String item:stack){
            System.out.println(item);
        }
        String result = stack.pop();
        System.out.println("弹出的元素是"+result);
        System.out.println("剩余大小："+stack.size());



        String test1 = "(((上海，北京)你好))";
        String test2 = "(nick(handsome)";
        String test3 = "(nick)so)handsome";

        System.out.println("匹配括号结果");
        System.out.println(test1+":"+isMatch(test1));
        System.out.println(test2+":"+isMatch(test2));
        System.out.println(test3+":"+isMatch(test3));


        // 中缀表达式 3*（17-15）+18/6 = 9
        String[] notation={"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        System.out.println("计算结果："+caculate(notation));
    }


    /**
     * 括号匹配问题
     * @param str 括号组成的字符串
     * @return 如果匹配返回true，不匹配返回false
     */
    public static boolean isMatch(String str){
        Stack<Character> stack = new Stack<>();
        for(char c:str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                Character result = stack.pop();
                if(result == null){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    /**
     *  对逆波兰表达式的计算
     * @param notation 逆波兰表达式的数组表示方式
     * @return 逆波兰表达式的计算结果
     */
    public static int caculate(String[] notation){
        Stack<Integer> stack = new Stack<>();
        int left,right,result;
        for(String item: notation){
            switch (item){
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    result = left+right;
                    stack.push(result);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    result = left-right;
                    stack.push(result);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    result = left*right;
                    stack.push(result);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    result = left/right;
                    stack.push(result);
                    break;
                default:
                    result = Integer.parseInt(item);
                    stack.push(result);
                    break;
            }
        }

        return stack.pop();
    }
}
