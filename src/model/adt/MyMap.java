package model.adt;

import exceptions.ExpressionException;

import java.util.HashMap;
import java.util.Map;

public class MyMap<K, V> implements IMyMap<K, V> {
    private Map<K, V> map;

    public MyMap() {
        map = new HashMap<K, V>();
    }

    public V get(K key) throws ExpressionException {
        if (!map.containsKey(key)) {
            throw new ExpressionException("Key not found");
        }
        return map.get(key);
    }

    public void insert(K key, V value) {
        map.put(key, value);
    }

    public boolean contains(K key) {
        return map.containsKey(key);
    }

    public void remove(K key) throws ExpressionException {
        if (!map.containsKey(key)) {
            throw new ExpressionException("Key not found");
        }
       map.remove(key);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (K key : map.keySet()) {
            str.append(key.toString()).append(" -> ").append(map.get(key));
            str.append("\n");
        }
        return "MyMap contains: " + str.toString();
    }
}
