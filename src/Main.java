import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws Exception {
        LongAdder total = new LongAdder();
        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 3; i++) {
            threadPool.submit(new MyRunnable(total));
        }
        threadPool.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println(total.sum());
        threadPool.shutdown();
    }
}