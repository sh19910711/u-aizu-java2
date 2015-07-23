public class ProducerConsumerTest {
    public static void main(String[] args) {
        CircularQueue c = new CircularQueue(1); 
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);
        Producer p2 = new Producer(c, 2);
        Consumer c2 = new Consumer(c, 2);
        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }
}

