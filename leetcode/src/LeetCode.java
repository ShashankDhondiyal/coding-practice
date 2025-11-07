import java.util.Stack;

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
}
