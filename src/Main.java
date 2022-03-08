import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws Exception {
        LongAdder total = new LongAdder();
        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        MyCallable myCallable = new MyCallable();
        Long[][] arrShops = new Long[3][];

        for (int i = 0; i < arrShops.length; i++) {
            arrShops[i] = threadPool.submit(myCallable).get();
        }
        for (Long[] shop : arrShops) {
            Arrays.stream(shop)
                    .forEach(x -> threadPool.submit(() -> total.add(x)));
        }

        threadPool.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println(total.sum());
        threadPool.shutdown();
    }
}