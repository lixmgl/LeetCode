import java.util.*;
class MinStack {
    int[] stack = new int[15];
    int minVal= Integer.MAX_VALUE;
    int index=-1;
    public void push(int x) {
        if(index+1>=stack.length){
            int[] newStack=new int[2*stack.length];
            for(int i=0;i<=index;i++){
                newStack[i]=stack[i];
            }
            ++index;
            newStack[index]=x;
            stack=newStack;
            minVal=Math.min(minVal,x);
            return;
        }
        ++index;
        stack[index]=x;
        minVal=Math.min(minVal,x);
    }

    public void pop() {
        if(stack[index]!=minVal){
            stack[index]=Integer.MAX_VALUE;
            --index;
            return;
        }
        stack[index]=Integer.MAX_VALUE;
        --index;
        minVal=Integer.MAX_VALUE;;
        for(int i=0;index<stack.length&&i<=index;i++){
            minVal=Math.min(stack[i],minVal);
        }
    }

    public int top() {
        return stack[index];
    }

    public int getMin() {
        return minVal;
    }
}
