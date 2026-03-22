package ex05;

import java.util.Vector;
import ex04.Command;

public class CommandQueue implements Queue {
    private Vector<Command> tasks = new Vector<Command>();
    private boolean waiting = false;
    private boolean shutdown = false;

    public void shutdown() {
        shutdown = true;
    }

    public CommandQueue() {
        new Thread(new Worker()).start();
    }

    public synchronized void put(Command r) {
        tasks.add(r);
        if (waiting) {
            notifyAll();
        }
    }

    public synchronized Command take() {
        if (tasks.isEmpty()) {
            try {
                waiting = true;
                wait();
            } catch (InterruptedException ie) {
                waiting = false;
            }
        }
        return (Command) tasks.remove(0);
    }

    private class Worker implements Runnable {
        public void run() {
            while (!shutdown) {
                Command r = take();
                try {
                    r.execute();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }
}
