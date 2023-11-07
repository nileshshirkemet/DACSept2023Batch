package components;

import java.io.Serializable;

public class GreeterBean implements Serializable {
    
    private String person;
    private String period;
    private int count;

    public final String getPerson() {
        return person;
    }

    public final void setPerson(String person) {
        this.person = person;
    }

    public final String getPeriod() {
        return period;
    }

    public final void setPeriod(String period) {
        this.period = period;
    }

    public String getGreetingMessage() {
        if(person == null)
            return "Welcome Visitor";
        count += 1;
        return String.format("Good %s %s", period, person);
    }

    public int getGreetCount() {
        return count;
    }
}
