package model.state;

import exceptions.EmptyStackException;

public interface IExecutionStack<T> {
    IStatement pop() throws EmptyStackException;
    void push(IStatement s);
    boolean isEmpty();
    int size();
}
