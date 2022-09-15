package dsa.binaryTree;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }


    public static void main(String[] args) {
        int[] nums = {-10,1,3,1,4,10,3,9,4,5,1};
        KthLargest kthLargest = new KthLargest(7, nums);
        System.out.println("return " + kthLargest.add(3));
        System.out.println("return " + kthLargest.add(2));
        System.out.println("return " + kthLargest.add(3));
//        System.out.println(kthLargest.root.val);
//        System.out.println(kthLargest.root.cnt);
//        System.out.println(kthLargest.root.left.val);
//        System.out.println(kthLargest.root.left.cnt);
//        System.out.println(kthLargest.root.right.val);
//        System.out.println(kthLargest.root.right.cnt);
//        System.out.println(kthLargest.root.right.right.val);
//        System.out.println(kthLargest.root.right.right.cnt);

    }


}


