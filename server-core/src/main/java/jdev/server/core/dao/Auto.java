package jdev.server.core.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "ID_AUTO", length = 8, nullable = false)
    String idAuto;

    @Column(name = "BRAND", length = 32, nullable = false)
    String brand;

    @Column(name = "MODEL", length = 32,  nullable = false)
    String model;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinTable(name = "user_auto", joinColumns = {
            @JoinColumn(name = "AUTO_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID",
                    nullable = false, updatable = false) })
    java.util.Set<User> users;

    public String toString() {
        return "Point{ id=" + id + ", idAuto=" + idAuto + ", idUser=" + brand + ", model=" + model + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto = idAuto;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public java.util.Set<User> getUsers() {
        return users;
    }

    public void setUsers(java.util.Set<User> users) {
        this.users = users;
    }
}
