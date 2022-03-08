import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long[]> {
    private final Random random = new Random();

    @Override
    public Long[] call() throws Exception {
        Long[] arr = new Long[random.nextInt(1, 20)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextLong(1500);
        }
        return arr;
    }
}