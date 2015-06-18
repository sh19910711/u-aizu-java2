// 2) Also, modify  "ProducerConsumerTest.java"
//    to change the size of the queue
//    and add more object of the "Producer" and the "Consumer"
//    in the main method to show the next running result.
public class ProducerConsumerTest {
    public static void main(String[] args) {
        // Producer p1 = new Producer(c, 1);
        // Consumer c1 = new Consumer(c, 1);
        // Producer p2 = new Producer(c, 2);
        // Consumer c2 = new Consumer(c, 2);
        // p1.start();
        // c1.start();
        // p2.start();
        // c2.start();
        int size = 10;
        CircularQueue c = new CircularQueue(4);
        Producer[] producers = new Producer[size];
        Consumer[] consumers = new Consumer[size];
        for ( int i = 0; i < size; ++ i ) {
          producers[i] = new Producer(c, i);
          consumers[i] = new Consumer(c, i);
        }
        for ( int i = 0; i < size; ++ i ) {
          producers[i].start();
          consumers[i].start();
        }
    }
}

