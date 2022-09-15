package dsa.hash;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    private final int MAX_LEN = 100000; // 初始化桶的数量
    private List<Integer>[] set;      // 使用数组实现哈希集合

    public MyHashSet() {
        set = (List<Integer>[])new ArrayList[MAX_LEN];
    }

    public void add(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            // 如果键不存在，则添加
            if (set[index] == null) {
                set[index] = new ArrayList<Integer>();
            }
            set[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos >= 0) {
            // 如果键存在，则删除
            set[index].remove(pos);
        }
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        return pos >= 0;
    }
    /** 返回对应的桶的索引 */
    private int getIndex(int key) {
        return key % MAX_LEN;
    }

    /** 在特定的桶中搜索键，如果该键不存在则返回 -1 */
    private int getPos(int key, int index) {
        // 每个桶中包含一个列表.
        List<Integer> temp = set[index];
        if (temp == null) {
            return -1;
        }
        // 遍历所有桶中的元素来寻找特定的键.
        for (int i = 0; i < temp.size(); ++i) {
            if (temp.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

}
