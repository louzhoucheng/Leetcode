package contest;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述：
 * @创建者： Louzhoucheng
 * @日期： 2017-04-16 23:25
 * @修改者： Louzhoucheng
 * @修改日期： 2017-04-16 23:25
 * @版本： v1.0
 */
public class Test {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方

    public static void main(String[] args) {
        final Test test = new Test();

        new Thread(() -> test.insert(Thread.currentThread())).start();

        new Thread(() -> test.insert(Thread.currentThread())).start();
    }

    public synchronized void insert(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "得到了锁");
                for (int i = 0; i < 50000; i++) {
                    arrayList.add(i);
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName() + "获取锁失败");
        }
    }
}
