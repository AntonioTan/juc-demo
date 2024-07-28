/**
 * @author tantianyi
 * Date: 7/29/24
 * Time: 上午12:32
 * Project Name: juc-demo
 * Package Name: PACKAGE_NAME
 */
public class ThreadDemo1 {
    static class SaleMan extends Thread {
        private int goodsAmt = 10;
        SaleMan(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                if (goodsAmt>0) {
                    ThreadUtil.joutput("sell one good, goodsAmot minus from " + (goodsAmt) + " to " + (--goodsAmt));
                }
            }
        }
    }

    static class SalemanBehavior implements Runnable {
        private int goodsAmt = 10;

        @Override
        public void run() {
            for (int i=0; i<100; i++) {
                if (goodsAmt>0) {
                    ThreadUtil.joutput("sell one good, goodsAmot minus from " + (goodsAmt) + " to " + (--goodsAmt));
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            SalemanBehavior salemanBehavior = new SalemanBehavior();
            Thread t = new Thread(salemanBehavior, "thread-" + (i+1));
            t.start();
//            Thread t1 = new SaleMan("thread-"+(i+1));
//            t1.start();
        }
    }
}
