import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author tantianyi
 * Date: 7/29/24
 * Time: 上午12:34
 * Project Name: juc-demo
 * Package Name: PACKAGE_NAME
 */
public class ThreadUtil {
    public static Executor threadpool = Executors.newFixedThreadPool(10);
    public static void joutput(String msg) {
        String msgHeader = "[" + Thread.currentThread().getName() + "]: ";
        synchronized (System.out) {
            execute(() -> {
                System.out.println(msgHeader + msg);
            });
        }
    }

    public static void execute(Runnable runnable) {
        threadpool.execute(runnable);
    }
}
