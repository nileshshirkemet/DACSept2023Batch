package tourism;

import java.io.*;
import java.util.*;

public class Site implements AutoCloseable, Serializable {
    
    private String title;
    private List<Visitor> visitors;

    private Site(String title) {
        this.title = title;
        this.visitors = new ArrayList<Visitor>();
    }

    public final String getTitle() { return title; }

    public final List<Visitor> getVisitors() { return visitors; }

    public Visitor getVisitor(String id) {
        return visitors.stream()
                .filter(v -> v.name.equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Visitor visitor = new Visitor(id);
                    visitors.add(visitor);
                    return visitor;
                });
    }

    public void close() throws IOException {
        String doc = title + ".store";
        try(var output = new ObjectOutputStream(new FileOutputStream(doc))){
            output.writeObject(this); //serialization
        }
    }

    //builder method
    public static Site load(String name) {
        String doc = name + ".store";
        try(var input = new ObjectInputStream(new FileInputStream(doc))){
            return (Site) input.readObject(); //deserialization
        }catch(Exception e){
            return new Site(name);
        }
    }
}
