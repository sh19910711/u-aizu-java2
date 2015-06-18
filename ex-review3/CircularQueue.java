// 1) Fill in code necessary
//    to implement a locking mechanism among producers and consumers
//    in "CircularQueue.java" to show a correct result. 
class CircularQueue {
    private int contents[], size;    
    private int head, tail;         
    private int count;

    public CircularQueue(int sz) {
        size = sz; 
        head = tail = 0;
        count = 0;
        contents = new int[size];
    }

    synchronized public int get() throws InterruptedException {
        while ( count == 0 ) {
          try {
            wait();
          } catch(InterruptedException ie) {
            ie.printStackTrace();
            System.exit(0);
          }
        }
        int res;
        res = contents[tail];
        tail = (tail + 1) % size;
        count--;
        notifyAll();
        return res;
    }

    synchronized public void put(int value, String name) throws InterruptedException { 
        while ( count >= size ) {
          try {
            wait();
          } catch(InterruptedException ie) {
            ie.printStackTrace();
            System.exit(0);
          }
        }
        contents[head] = value; 
        head = (head + 1) % size;
        count++;
        notifyAll();
        System.out.println(name + " put: " + value);
    }
}

