package jdev.server.core.dao;

import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "NAME", length = 32, nullable = false)
    String name;

    public String toString() {
        return "Point{ id=" + id + ", name=" + name + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
