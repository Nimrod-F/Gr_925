package model.adt;

import exceptions.EmptyStackException;

import java.util.Stack;

public class MyStack<T> implements IMyStack<T> {
    Stack<T> stack;

    public MyStack() {
        stack = new Stack<T>();
    }

    public T pop() throws EmptyStackException {
        if (stack.isEmpty()) {
            throw new EmptyStackException("Stack is empty!");
        }
        return stack.pop();
    }

    public void push(T element) {
        stack.push(element);
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    Stack<T> getStack() {
        return this.stack;
    }

    void setStack(Stack<T> stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (T item : stack) {
            str.append(item);
            str.append("\n");
        }
        return "MyStack contains: " + str.toString();
    }
}
