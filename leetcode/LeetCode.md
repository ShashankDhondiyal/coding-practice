# Leetcode Questions

### Table of Contents

1. Valid Parentheses
2. Implement Queue Using Stacks
3. Evaluate Boolean Binary Tree
4. Same Tree
5. Implement Stack Using Queues
6. Remove N<sup>th</sup> Node From End of List

## Valid Parentheses

Given a string `s` containing just the characters `(,),{,},[` and `]`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

**Examples:**

| Input | Ouput |
| --- | --- |
| `()` | true |
| `()[]{}` | true |
| `(]` | false |
| `([])` | true |
| `([)]` | false |

## Implement Queue Using Stacks

Implement a first-in-first-out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

1. `void push(int x)` Pushes element x to the back of the queue.
2. `int pop()` Removes the element from the front of the queue and returns it.
3. `int peek()` Returns the element at the front of the queue.
4. `boolean empty()` Returns true if the queue is empty, false otherwise.

Notes:

- You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.

**Examples** 

| Input | Ouput |
| --- | --- |
| ["MyQueue","push","push","peek","pop","empty"], [[],[1],[2],[],[],[]] | [null, null, null, 1, 1, false] |

**Explanation**

```
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
```

## Evaluate Boolean Binary Tree

You are given the root of a full binary tree with the following properties:

1. Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
2. Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.

**Examples** 

| Input | Ouput |
| --- | --- |
| `[2,1,3,null,null,0,1]` | True |
| `[0]` | False |

## Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

**Examples** 

| Input | Ouput |
| --- | --- |
| `p = [1,2,3], q = [1,2,3]` | True |
| `p = [1,2], q = [1,null,2]` | False |
| `p = [1,2,1], q = [1,1,2]` | False |

## Implement Stack Using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

- `void push(int x)` Pushes element x to the top of the stack.
- `int pop()` Removes the element on the top of the stack and returns it.
- `int top()` Returns the element on the top of the stack.
- `boolean empty()` Returns true if the stack is empty, false otherwise.

Notes:

- You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.

**Examples** 

| Input | Ouput |
| --- | --- |
| ["MyStack","push","push","top","pop","empty"], [[],[1],[2],[],[],[]] | [null, null, null, 2, 2, false] |

*Follow-up: Can you implement the stack using only one queue?*

## Remove N<sup>th</sup> Node From End of List

Given the head of a linked list, remove the n<sup>th</sup> node from the end of the list and return its head.

**Examples** 

| Input | Ouput |
| --- | --- |
| `head = [1,2,3,4,5], n = 2` | [1,2,3,5] |
| `head = [1], n = 1` | [] |
| `head = [1,2], n = 1` | [1] |