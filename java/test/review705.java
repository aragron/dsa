import java.util.Arrays;

public class review705 {

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

    }
}

class MyHashSet implements MySet {
    private int[] array;
    private int p;
    private int len;
    private float incr = 0.75f;

    public MyHashSet(){
        this.len = 8;
        this.array = new int[this.len];
        this.p = 0;
    }

    @Override
    public void add(int key) {
        if (p >= len * incr) {
            len *= 2;
            int[] newArray = new int[len];
            if (p >= 0) System.arraycopy(array, 0, newArray, 0, p);
            array = newArray;
        }
        if (contains(key)) {
            return;
        }
        array[p++] = key;
    }

    @Override
    public boolean contains(int key) {
        for (int i = 0; i < p; i++) {
            if (array[i] == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (!contains(key)){
            return;
        }
        int index=-1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                index = i;
            }
        }
        if (index < 0 || index >= p) {return;}
        if ((p-1)*2 < len * incr) {
            len /= 2;
        }
        int[] newArray = new int[len];
        System.out.println("index: " + index + ", p: " + p + ", len： " + len + ", key: " + key);
        if (index == 0) {
            System.arraycopy(this.array,1,newArray,0,--p);
        } else if (index == p-1) {
            System.arraycopy(this.array,0,newArray,0,--p);
        }else {
            System.arraycopy(this.array,0,newArray,0,index);
            System.arraycopy(this.array,index+1,newArray,index,p-index-1);
            p--;
        }
        this.array = newArray;
    }
    @Override
    public String myToString() {
        //System.out.println("p的值："+p);
        int[] ints = new int[p];
        System.arraycopy(array, 0, ints, 0, p);
        return Arrays.toString(ints);
    }
}
interface MySet {
     void add(int key);
     boolean contains(int key);
     void remove(int key);
     String myToString();
}
