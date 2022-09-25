/*
2. Написать реализацию очереди на основе массива; Реализовать методы size(), empty(), offer(), poll(), peek()
 */

import java.util.ArrayList;

public class task2MyQueue {
        private ArrayList<Object> arrayList;

        public static void main(String[] args) {
            task2MyQueue mq = new task2MyQueue();
            mq.offer(1);
            mq.offer(2);
            mq.offer(3);
            System.out.println("offer(null) " + mq.offer(null));
            System.out.println(mq);
            mq.poll();
            System.out.println(mq);
            mq.offer(6);
            System.out.println(mq);
            System.out.println(mq.size());
            System.out.println("peek() " + mq.peek());
            System.out.println(mq);
            mq.poll();
            mq.poll();
            System.out.println(mq.isEmpty());
            System.out.println("pool() " + mq.poll());
            System.out.println(mq.isEmpty());
            System.out.println(mq);
            System.out.println(mq.size());
        }

        public task2MyQueue() {
            this.arrayList = new ArrayList<>();
        }

        public Integer size() {
            return this.arrayList.size();
        }

        public boolean isEmpty() {
            return this.arrayList.isEmpty();
        }
        public boolean offer(Object item) {
            if (item == null) {
                return false;
            }
            this.arrayList.add(item);
            return true;
        }
        public Object poll() {
            if (isEmpty()) {
                return null;
            } else {
                Object temp = this.arrayList.get(0);
                this.arrayList.remove(0);
                return temp;
            }
        }
        public Object peek() {
            if (isEmpty()) {
                return null;
            } else {
                return this.arrayList.get(0);
            }
        }

    @Override
    public String toString() {
        return "MyQueue{" + arrayList +
                '}';
    }
}
