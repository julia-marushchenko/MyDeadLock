/**
 *  Java program to create a deadlock.
 */

package mythreads;

/**
 *  ThreadDemo class.
 */
public class ThreadDemo {

    // Field what should be protected from multiple access.
    public static Object lock = new Object();
    public static Object lock1 = new Object();

    // JVM entry point.
    public static void main(String[] args) {

        // Creating two objects of class ThreadClass.
        ThreadClass td = new ThreadClass();
        ThreadClass1 td1 = new ThreadClass1();

        // Starting threads.
        td.start();
        td1.start();

    }

    // Nested class ThreadClass.
    private static class ThreadClass extends Thread {

        // Method run().
        public void  run() {
            synchronized (lock) {
                System.out.println("Holding lock.");
                System.out.println("Waiting for lock1.");
                synchronized (lock1) {
                    System.out.println("Holding lock1.");
                }
            }
        }
    }

    // Nested class ThreadClass1.
    private static class ThreadClass1 extends Thread {

        // Method run().
        public void  run() {
            synchronized (lock1) {
                System.out.println("Holding lock1.");
                System.out.println("Waiting for lock.");
                synchronized (lock) {
                    System.out.println("Holding lock.");
                }
            }
        }
    }
}

