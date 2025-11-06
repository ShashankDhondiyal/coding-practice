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
}
