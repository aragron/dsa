package dsa.hash;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    private final int MAX_LEN = 100000;             // 初始化桶的数量
    private List<Pair<Integer, Integer>>[] map;     // 使用数组实现哈希集合

    public MyHashMap() {
        map = (List<Pair<Integer, Integer>>[])new ArrayList[MAX_LEN];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            // 如果不存在，则添加键值对 (key, value)
            if (map[index] == null) {
                map[index] = new ArrayList<Pair<Integer, Integer>>();
            }
            map[index].add(new Pair(key, value));
        } else {
            // 如果键存在，更新 value
            map[index].set(pos, new Pair(key, value));
        }
    }

    /** 返回键的映射结果，如果不存在映射关系则返回 -1 */
    public int get(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            return -1;
        } else {
            return map[index].get(pos).getValue();
        }
    }

    /** 如果存在映射关系，则移除键值对 */
    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos >= 0) {
            map[index].remove(pos);
        }
    }

    /** 返回指定桶的索引 */
    private int getIndex(int key) {
        return key % MAX_LEN;
    }

    /** 在特定的桶中寻找 key，如果不存在则返回 -1 */
    private int getPos(int key, int index) {
        // 每个桶中包含一个数组
        List<Pair<Integer, Integer>> temp = map[index];
        if (temp == null) {
            return -1;
        }
        // 遍历所有元素，在桶中寻找 key
        for (int i = 0; i < temp.size(); ++i) {
            if (temp.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    private class Pair<K,V> {
        private K key;
        private V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
