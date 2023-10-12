import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

class Program {

    static class Computation {

        private long start;

        public long compute(int lower, int upper) {
            start = System.currentTimeMillis();
            return IntStream.range(lower, upper + 1)
                    .parallel() //split the incoming stream into mutliple
                                //substreams which can process data in parallel
                    .mapToLong(Activity::perform)
                    .sum();
        }

        public CompletableFuture<Long> computeAsync(int lower, int upper) {
            //the supplied expression is evaluated by a worker thread allowing
            //the caller thread to resume execution and to accept the result
            //of evaluation in future when it is completed by that worker
            return CompletableFuture.supplyAsync(() -> compute(lower, upper));
        }

        public double time() {
            long stop = System.currentTimeMillis();
            return (stop - start) / 1000.0;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(args[0]);
        System.out.print("Computing...");
        var c = new Computation();
        var job = c.computeAsync(1, n)
                    .thenAccept(r -> {
                        System.out.println("Done!");
                        System.out.printf("Result = %d, computed in %.3f seconds.%n", r, c.time());                        
                    });
        while(!job.isDone()){
            System.out.print('.');
            Thread.sleep(500); //pause the current thread for 500 milliseconds
        }
    }
}
