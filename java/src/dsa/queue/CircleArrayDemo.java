package dsa.queue;

import java.util.Scanner;

public class CircleArrayDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(5);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("s: 显示队列");
            System.out.println("e: 推出程序");
            System.out.println("a: 添加数据");
            System.out.println("g: 取出数据");
            System.out.println("h: 查看队列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.listQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.push(value);
                    break;
                case 'g':
                    try {
                        int res = queue.pop();
                        System.out.printf("取出数据%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("数据头为%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
    }
}
    class CircleArray {

        private int maxSize;//数组最大容量
        private int front;//队列头
        private int rear;//队列尾
        private int[] arr;// 数组模拟队列

        public CircleArray(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
        }

        public boolean isFull() {
            System.out.printf("front: %d\n", front);
            System.out.printf("rear: %d\n", rear);
            System.out.printf("arr长度: %d\n", arr.length);
            return (rear + 1) % maxSize == front;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public void push(int n) {
            // 判断队列是否满
            if (isFull()) {
                System.out.println("队列满，不能加入数据~");
                return;
            }
            //直接将数据加入
            arr[rear] = n;
            //将 rear 后移, 这里必须考虑取模
            rear = (rear + 1) % maxSize;
        }


        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空！");
            }
            // 这里需要分析出 front是指向队列的第一个元素
            // 1. 先把 front 对应的值保留到一个临时变量
            // 2. 将 front 后移, 考虑取模
            // 3. 将临时保存的变量返回
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        public int size() {
            // rear = 2
            // front = 1
            // maxSize = 3
            return (rear + maxSize - front) % maxSize;
        }

        public void listQueue() {
            if (isEmpty()) {
                System.out.println("队列为空！");
                return;
            }
            // 思路：从front开始遍历，遍历多少个元素
            // 动脑筋
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空！");
            }
            return arr[front + 1];
        }
    }
