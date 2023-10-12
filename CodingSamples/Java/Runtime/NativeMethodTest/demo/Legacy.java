class Legacy {

    public native static int countPrimes(long first, long last);

    public native static long[] selectPrimes(long start, int count, boolean all);

    //code in a static block is executed once when JVM loads
    //the class in which it is defined
    static {
        //load the platform-specific library containing implementation
        //of native method, this library will be searched in each 
        //location included in the value of java.library.path property
        System.loadLibrary("legacyjni");
    }
}
