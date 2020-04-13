package leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HelloJava {

    public static void main(String[] args) {
        boolean timeout = true;
        synchronized (HelloJava.class) {
            CountDownLatch latch = new CountDownLatch(1);
            latch.countDown();
            try {
                timeout = latch.await(1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("timeout=" + timeout);
            }
        }
    }

    private static void testVarargs(Object... args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("" + args[i]);
        }
    }

}
