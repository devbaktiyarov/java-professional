import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String s = "Tony Ferguson";
//                String r = s.toUpperCase();
//                System.out.println(r);
//                System.out.println("\n" + s.indexOf("o"));
//                System.out.println("\n" + s.substring(s.indexOf("F")));
//            }
//        });
//        thread.start();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread t = new Thread();
//                t.setDaemon(true);
//                return t;
//            }
//        });
//
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//                while(i < 100) {
//                    System.out.println(i++ + "HHHHHHHHHHHH");
//                    i++;
//                }
//            }
//        });
//
//    }
//}
        Thread thread = new Thread(new OtherThread());
        thread.start();

        ExecutorService ex = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread1 = new Thread();
                thread1.setDaemon(true);
                return thread1;
            }
        });
        ex.execute(new Runnable() {
            @Override
            public void run() {
                for (int count = 0; count < 100; count++) {
                    System.out.println("Count000000000000000 " + count);
                }
            }
        });
        ex.execute(new Runnable() {
            @Override
            public void run() {
                for (int count1 = 0; count1 < 100; count1++) {
                    System.out.println("Count1111111111111111 " + count1);
                }
            }
        });
        ex.execute(new Runnable() {
            @Override
            public void run() {
                for (int count2 = 0; count2 < 100; count2++) {
                    System.out.println("Count2222222222222222 " + count2);
                }
            }
        });


//        for (int j = 0; j < 100; j++) {
//            System.out.println("j " + j + " = " + Thread.currentThread());
//            Thread.sleep(2000);
//            thread.join();
//            if (j == 20) {
//                System.out.println(Thread.currentThread().isAlive());
//            }
//        }
    }

}

class OtherThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i " + i + " = " + Thread.currentThread());
//                Thread.sleep(2000);
            if (i == 20) {
                System.out.println(Thread.currentThread().isAlive());
            }

        }
    }
}
