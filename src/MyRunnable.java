import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class MyRunnable implements Runnable {
    private final Random random = new Random();
    private LongAdder total;

    public MyRunnable(LongAdder total) {
        this.total = total;
    }

    @Override
    public void run() {
        for (int i = 0; i < random.nextLong(10); i++) {
            total.add(random.nextLong(1000));
        }
    }
}