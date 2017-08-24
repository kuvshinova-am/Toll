package jdev.server.core.dao;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "ID_AUTO", length = 8, nullable = false, unique = true)
    String idAuto;

    @Column(name = "BRAND", length = 32, nullable = false)
    String brand;

    @Column(name = "MODEL", length = 32,  nullable = false)
    String model;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "autos")
    java.util.Set<User> users = new HashSet<>();

    public String toString() {
        return "Auto{ id=" + id + ", idAuto=" + idAuto + ", idUser=" + brand + ", model=" + model + " }";
    }

    public Auto(Integer id, String idAuto, String brand, String model) {
        this.id = id;
        this.idAuto = idAuto;
        this.brand = brand;
        this.model = model;
    }

    public Auto(Integer id, String idAuto, String brand, String model, Set<User> users) {
        this.id = id;
        this.idAuto = idAuto;
        this.brand = brand;
        this.model = model;
        this.users = users;
    }

    public Auto() {
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
