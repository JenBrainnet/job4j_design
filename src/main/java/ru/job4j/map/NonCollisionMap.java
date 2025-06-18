package ru.job4j.map;

import java.util.*;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = indexForKey(key);
        boolean inserted = table[index] == null;
        if (inserted) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
        }
        return inserted;
    }

    @Override
    public V get(K key) {
        V value = null;
        int index = indexForKey(key);
        MapEntry<K, V> entry = table[index];
        if (entry != null && keysEqual(key, entry.key)) {
            value = entry.value;
        }
        return value;
    }

    @Override
    public boolean remove(K key) {
        boolean removed = false;
        int index = indexForKey(key);
        MapEntry<K, V> entry = table[index];
        if (entry != null && keysEqual(key, entry.key)) {
            table[index] = null;
            count--;
            modCount++;
            removed = true;
        }
        return removed;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int index;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private int hash(int hashCode) {
        return hashCode == 0 ? 0 : hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        count = 0;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int index = indexForKey(entry.key);
                if (newTable[index] == null) {
                    newTable[index] = entry;
                    count++;
                }
            }
        }
        table = newTable;
    }

    private boolean keysEqual(K k1, K k2) {
        return Objects.hashCode(k1) == Objects.hashCode(k2)
                && Objects.equals(k1, k2);
    }

    private int indexForKey(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}