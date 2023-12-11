import java.util.Map;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> data_stack;
    private Stack<Integer> min_stack;
    public MinStack() {
        this.data_stack = new Stack<>();
        this.min_stack = new Stack<>();
    }

    public void push(int val) {
        data_stack.push(val);
        if(min_stack.isEmpty()){
            min_stack.push(val);
        }else {
            min_stack.push(Math.min(min_stack.peek(),val));
        }
    }

    public void pop() {
        if (!data_stack.isEmpty()) {
            data_stack.pop();
            min_stack.pop();
        }
    }

    public int top() {
        return data_stack.peek();
    }

    public int getMin() {
     return min_stack.peek();
    }
}
