import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class LeetCode {
    
    /* Valid Parentheses */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> myStack = new Stack<>();

        char[] inputs = s.toCharArray();

        for (char input : inputs) {
            switch (input){
                case '(' -> myStack.push(input);
                case '[' -> myStack.push(input);
                case '{' -> myStack.push(input);
                case ')' -> {
                    if ((myStack.isEmpty()) || (myStack.pop() != '(')) {
                        return false;
                    }
                }
                case ']' -> {
                    if ((myStack.isEmpty()) || (myStack.pop() != '[')) {
                        return false;
                    }
                }
                case '}' -> {
                    if ((myStack.isEmpty()) || (myStack.pop() != '{')) {
                        return false;
                    }
                }
            }
        }
        return myStack.isEmpty();
    }

    /* Implement Queue Using Two Stacks */
    class MyQueue {
        private Stack<Integer> left = new Stack<>();
        private Stack<Integer> right = new Stack<>();

        public MyQueue() {}

        public void push(int x) {
            left.push(x);
        }

        public int pop() {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            int data =  right.pop();

            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            return data;
        }

        public int peek() {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            int data =  right.peek();

            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            return data;
        }

        public boolean empty() {
            return left.isEmpty();
        }
    }

    /* Evaluate Boolean Binary Tree */
    public boolean evaluateTree(TreeNode root) {
        return switch (root.val) {
            case 0 -> false;
            case 1 -> true;
            case 2 -> evaluateTree(root.left) || evaluateTree(root.right);
            case 3 -> evaluateTree(root.left) && evaluateTree(root.right);
            default -> throw new IllegalArgumentException("Invalid node value: " + root.val);
        };
    }

    /* Same Tree */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /* Implement Stack Using Queue */
    class MyStack {
        private Queue<Integer> myQ = new LinkedList<>();
        boolean rotated = false;

        public MyStack() {}
        
        public void push(int x) {
            if (rotated) {
                for (int i = 0; i < (myQ.size() - 1); i++) {
                    myQ.add(myQ.remove());
                }
            }
            myQ.add(x);
            rotated = false;
        }
        
        public int pop() {
            if (!rotated) {
                for (int i = 0; i < (myQ.size() - 1); i++) {
                    myQ.add(myQ.remove());
                }
            }
            rotated = false;
            return myQ.remove();
            
        }
        
        public int top() {
            if (!rotated) {
                for (int i = 0; i < (myQ.size() - 1); i++) {
                    myQ.add(myQ.remove());
                }
            }
            rotated = true;
            return myQ.peek();

        }
        
        public boolean empty() {
            return myQ.isEmpty();
        }
    }

}
