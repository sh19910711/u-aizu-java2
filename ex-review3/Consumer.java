class Consumer extends Thread {
    private CircularQueue boundedBuffer;
    private int number;

    public Consumer(CircularQueue c, int number) {
        super("Consumer #" + number);
        boundedBuffer = c;
        this.number = number;
    }
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = boundedBuffer.get();
	    // System.out.println("In consumer get: " + System.nanoTime());
            System.out.println(getName() + " got: " + value);
        }
    }
}

