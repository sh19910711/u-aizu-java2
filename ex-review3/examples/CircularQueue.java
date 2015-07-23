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

    public int get() {
        int res;
        res = contents[tail];
        tail = (tail + 1) % size;
        count--;
        return res;
    }

    public void put(int value, String name) { 
        contents[head] = value; 
        head = (head + 1) % size;
        count++;
        System.out.println(name + " put: " + value);
    }
}

