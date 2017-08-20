package jdev.server.core.dao;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "FIRST_NAME", nullable = false)
    String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    String lastName;

    @Column(name = "PATRONYMIC")
    String patronymic;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
    Date dateOfBirth;

    @Column(name = "DRIVERS_LICENSE", length = 10, nullable = false)
    Integer driversLicense;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @PrimaryKeyJoinColumn(name = "ID")
    Integer role;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Auto.class)
    @JoinTable(name = "user_auto", joinColumns = {
            @JoinColumn(name = "USER_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "AUTO_ID",
                    nullable = false, updatable = false) })
    java.util.Set<Auto> autos;

    public String toString() {
        return "Point{ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", patronymic=" + patronymic
                + ", dateOfBirth=" + dateOfBirth + ", " + "driversLicense=" + driversLicense + ", role=" + role + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(Integer driversLicense) {
        this.driversLicense = driversLicense;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }
}
