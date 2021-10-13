package multithread.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * ReetrantReadWriteLock实现
 * @author itbird
 *
 */
public class ReadWriteLockTestMulitRead {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void get(Thread thread) {
        lock.readLock().lock();
        System.out.println(thread.getName() + "start time:" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ":正在进行读操作……");
        }
        System.out.println(thread.getName() + ":读操作完毕！");
        System.out.println(thread.getName() + "end time:" + System.currentTimeMillis());
        lock.readLock().unlock();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        }).start();
    }

}