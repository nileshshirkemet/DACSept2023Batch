//a class that does not implicitly extend another class
//implicitly inherits from java.lang.Object which is 
//the root type in the inheritance model of Java
class Interval {

    private int min;
    private int sec;

    public Interval(int m, int s) {
        min = m + s / 60;
        sec = s % 60;
    }

    public int minutes() { return min; }

    public int seconds() { return sec; }

    public int time() { return 60 * min + sec; }

    public String toString() {
        if(sec < 10)
            return min + ":0" + sec;
        return min + ":" + sec;
    }

    public int hashCode() {
        return min + sec;
    }

    public boolean equals(Object other) {
        return min == other.min && sec == other.sec;
        Interval that = (Interval) other; //explicit down-casting
        return min == that.min && sec == that.sec;
    }
}
