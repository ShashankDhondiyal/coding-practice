import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class LeetCode {
    
    /* Valid Parentheses */
    public boolean isValid(String s) {
        
        /* The result will alwyas be invalid if there are an odd number of inputs (nubmer of chars in s) to check
         * because there will always be one parenthesis, bracket, or brace that is unpaired.
         */
        if (s.length() % 2 == 1) {
            return false;
        }

        /* Assuming there is an even number of chars to check,
         * we can use a stack to keep track of what we have already encountered.
         * The benefit of using a stack is we can check the inner-most opening char since it will be at the top of the stack.
         */
        Stack<Character> myStack = new Stack<>();

        char[] inputs = s.toCharArray();

        for (char input : inputs) {
            switch (input){
                case '(' -> myStack.push(input);
                case '[' -> myStack.push(input);
                case '{' -> myStack.push(input);

                /* Since we know what the opening is, we can check our current char to see if it is the correct closing char.
                 * If our stack is empty and we're pushing a closing char, then the input is invalid.
                 */
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

        /* We want to check if the stack is empty in case we only read in opening chars,
         * because if we do not, there are no closing chars to match the opening chars until this point so our code will run without checking this case.
         */
        return myStack.isEmpty();
    }

    /* Implement Queue Using Two Stacks */
    class MyQueue {

        /* This code uses two stacks.
         * Because stacks are great for reversing things like lists,
         * we can use the first stack (left) to store our "queue" in reverse and the second (right) to reverse the first (left) stack.
         * This code is unoptimized, and has a run time of O(N) because of pop() and peek()
         */
        private Stack<Integer> left = new Stack<>();
        private Stack<Integer> right = new Stack<>();

        public MyQueue() {}

        /* This method pushes all our inputs to the left stack until we need to pop or peek.
         * This keeps insertion at O(1) run time.
         */
        public void push(int x) {
            left.push(x);
        }

        /* Because stacks are good reversing things,
         * we can use the right stack to reverse our left stack effectively mimicing a queue.
         * When we are done we can throw everything back into the left stack,
         * unfortunately at the cost of run time.
         */
        public int pop() {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            int data = right.pop();

            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            return data;
        }

        /* We can apply the same logic as in pop to peek but instead of removing the value, we just use peek() instead.
         */
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

        /* Return if everything has been dequeued (popped from stack).
         * O(1) run time.
        */
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
        
        // Adding this case if both are null so we do not recurse forever.
        if (p == null && q == null) {
            return true;
        }

        // The next two cases return if either one of the nodes are different.
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        
        // If the current nodes are the same, check the child nodes to make sure the whole tree is the same.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /* Implement Stack Using Queue */
    class MyStack {
        
        /* We can use a singular queue to mimic a stack.
         * We can enqueue all the elements (except the last element) from the front of the queue to the queue.
         * I also use a rotated variable to make sure specific orders of peeks() and pops() do not mess with the order of the queue.
         * This code is unoptimized.
         */
        private Queue<Integer> myQ = new LinkedList<>();
        boolean rotated = false;

        public MyStack() {}
        
        /* If our queue was rotated (eg. peek() was previous method),
         * Then if we add a new element, it would be the same as adding to the bottom of a stack.
         * We need to unrotate the queue before adding our next element so we can mimic adding to the top of a stack.
         * Otherwise, if it wasn't rotated, adding to the queue would already put the element to the top of the mimiced stack.
         * Worst case run time is O(n).
         */
        public void push(int x) {
            if (rotated) {
                for (int i = 0; i < (myQ.size() - 1); i++) {
                    myQ.add(myQ.remove());
                }
            }
            myQ.add(x);
            rotated = false;
        }
        
        /* If the queue was not rotated prior,
         * then the pop() would return what would be the bottom of our stack instead of the top.
         * To solve this, we can rotate the queue first so the last element of the queue would be at the top of the mimiced stack.
         * Or if it was already rotated (eg. peek() was previous method) then we can pop the front of the queue, which would be the top of the mimiced stack.
         * Worst case run time is O(n). 
        */
        public int pop() {
            if (!rotated) {
                for (int i = 0; i < (myQ.size() - 1); i++) {
                    myQ.add(myQ.remove());
                }
            }
            rotated = false;
            return myQ.remove();
            
        }

        /* Basically the same logical issue as pop().
         * Worst case run time is O(n).
        */
        public int top() {
            if (!rotated) {
                for (int i = 0; i < (myQ.size() - 1); i++) {
                    myQ.add(myQ.remove());
                }
            }
            rotated = true;
            return myQ.peek();

        }
        
        /* 
         * Returns if everything has been popped (dequeued from the queue).
         * Worst case run time is O(1).
        */
        public boolean empty() {
            return myQ.isEmpty();
        }
    }

    /* Remove Nth Node From End of List */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        /* This code is unoptimized.
         * First I start with getting the size of the list.
         * Worst case run time is O(n).
        */
        int size = 0;
        for (ListNode dummy = head; dummy != null; dummy = dummy.next) {
            size++;
        }

        /* Then I check if we are removing the first element.
         * If we are, we can just return the head as its next node.
         * Worst case run time is O(1).
         */
        if (n == size) {
            return head.next;
        }

        /* Otherwise, we traverse the list until we get to the element before the element we need to remove.
         * Then we set the next of the node we are on to the following node.
         * Worst case run time is O(n).
        */
        else {
            int i = 1;
            ListNode dummy = head;
            for (; i++ < size - n; dummy = dummy.next) {}
            dummy.next = dummy.next.next;
            return head;
        }
    }

    /* Increment Submatrices by One */
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        // Initalize the matrix as per the question guidlines
        int[][] mat = new int[n][n];

        for (int[] query : queries) {
            // only traverse the submatrix range from query indicies
            for (int row = query[0]; row <= query[2]; row++) {
                for (int col = query[1]; col <= query[3]; col++) {
                    mat[row][col]++;
                }
            }
        }
        // Worst case run time of O(n^3)
        return mat;
    }
}
