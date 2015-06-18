class Producer extends Thread {
    private CircularQueue boundedBuffer;
    private int number;

    public Producer(CircularQueue c, int number) {
        super("Producer #" + number);
        boundedBuffer = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            boundedBuffer.put(i, getName());
	    // System.out.println("In Producer put: " + System.nanoTime());
	    // System.out.println(getName() + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}