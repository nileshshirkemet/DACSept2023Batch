package tourism;

import java.io.Serializable;
import java.util.Date;

public class Visitor implements Serializable {
    
    String name;
    private int visitCount;
    private Date lastVisit;
    private transient long ticket; //ignore during serialization

    public Visitor(String name) {
        this.name = name;
    }

    public final String getName() { return name; }

    public final int getVisitCount() { return visitCount; }

    public final Date getLastVisit() { return lastVisit; }

    public final long getTicket() { return ticket; }

    public void visit() {
        visitCount += 1;
        lastVisit = new Date();
        ticket = System.currentTimeMillis() % 1000000;
    }
}
