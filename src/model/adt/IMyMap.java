package model.adt;

import exceptions.ExpressionException;

public interface IMyMap<K, V> {
    V get(K key) throws ExpressionException;
    void insert(K key, V value);
    boolean contains(K key);
    void remove(K key) throws ExpressionException;
}
