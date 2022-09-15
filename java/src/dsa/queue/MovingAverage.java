package dsa.queue;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    Queue<Integer> queue;
    int capacity;
    int sum;
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.capacity = size;
    }

    public double next(int val) {
        if (queue.size()==capacity){
            if (queue.isEmpty()){return 0;}
            int num = queue.poll();
            sum -= num;
        }
        queue.offer(val);
        sum+=val;
        return (double) sum/queue.size();
    }
}
