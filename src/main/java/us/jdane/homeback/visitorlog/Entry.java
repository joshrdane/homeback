package us.jdane.homeback.visitorlog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Entry {
    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String message;

    private Entry(String name, String message) {
        this.name = name;
        this.message = message;
    }

    protected Entry() {}

    public static Entry create(String name, String message) {
        return new Entry(name, message);
    }
}
