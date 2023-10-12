import java.util.stream.IntStream;

class Program {

    static class Computation {

        private long start;

        public long compute(int lower, int upper) {
            start = System.currentTimeMillis();
            return IntStream.range(lower, upper + 1)
                    .mapToLong(Activity::perform)
                    .sum();
        }

        public double time() {
            long stop = System.currentTimeMillis();
            return (stop - start) / 1000.0;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.print("Computing...");
        var c = new Computation();
        var r = c.compute(1, n);
        System.out.println("Done!");
        System.out.printf("Result = %d, computed in %.3f seconds.%n", r, c.time());
    }
}
