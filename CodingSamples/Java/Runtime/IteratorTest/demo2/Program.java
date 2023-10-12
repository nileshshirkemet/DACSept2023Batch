import java.util.*;

class Program {

    public static void main(String[] args) {
        if(args.length == 0){
            //Collection<Interval> store = new ArrayList<Interval>();
            //Collection<Interval> store = new LinkedList<Interval>();
            //Collection<Interval> store = new HashSet<Interval>();
            Collection<Interval> store = new TreeSet<Interval>();
            store.add(new Interval(4, 31));
            store.add(new Interval(7, 42));
            store.add(new Interval(5, 13));
            store.add(new Interval(3, 24));
            store.add(new Interval(6, 55));
            store.add(new Interval(2, 151));
            for(var i : store)
                System.out.println(i);
        }else{
            //Map<String, Interval> store = new HashMap<String, Interval>();
            Map<String, Interval> store = new TreeMap<String, Interval>();
            store.put("monday", new Interval(4, 31));
            store.put("tuesday", new Interval(7, 42));
            store.put("wednesday", new Interval(5, 13));
            store.put("thursday", new Interval(3, 24));
            store.put("friday", new Interval(6, 55));
            store.put("monday", new Interval(2, 31));
            Interval val = store.get(args[0]);
            if(val != null){
                System.out.printf("Value = %s%n", val);
            }else{
                for(var pair : store.entrySet())
                    System.out.printf("%-16s%s%n", pair.getKey(), pair.getValue());
            }
        }
    }
}
