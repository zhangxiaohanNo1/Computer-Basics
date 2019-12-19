package 数据结构.栈;

/**
 * @author zhangxiaohan
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack  = new ArrayStack<Integer>();
        for(int i = 0; i < 10; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
