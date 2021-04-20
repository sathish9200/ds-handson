import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            int op = sc.nextInt();
            if (op == 1) 
            {               
                q.enqueue(sc.nextInt());
            } else if (op == 2) 
            {        
                q.dequeue();
            } else if (op == 3) 
            {        
                System.out.println(q.peek());
            }
        }
        sc.close();
    }
    public static class MyQueue<Integer> {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();   
        public void enqueue(Integer num) 
        {
            stack1.push(num);
        }
        
        public Integer dequeue() {
            if (size() == 0) 
            {
                return null;
            }
            if (stack2.isEmpty()) 
            {
                shiftStacks();
            }
            return stack2.pop();
        }
        public Integer peek() {
            if (size() == 0) 
            {
                return null;
            }
            if (stack2.isEmpty()) 
            {
                shiftStacks();
            }
            return stack2.peek();
        }
        private void shiftStacks() 
        {
            if (stack2.isEmpty()) 
            {
                while ( ! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        public int size() {
            return stack1.size() + stack2.size();
        }
    }
}
