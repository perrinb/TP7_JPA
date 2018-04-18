package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Person {
    int idPerson;
    String firstname;
    String lastname;
    String email;
    Collection<Home> residences = new ArrayList<Home>();

    public Person() {
    }

    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID")
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany
    @JoinTable(name = "PERS_HOME", joinColumns = @JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name="HOME_ID", referencedColumnName="HOME_ID"))
    @JsonIgnore
    public Collection<Home> getResidences() {
        return residences;
    }

    public void setResidences(Collection<Home> residences) {
        this.residences = residences;
    }

    @Override
    public String toString() {
        return "Person [id = " + idPerson + ", lastname = " + lastname + ", firstname = " + firstname + ", email = " + email + "]";
    }
}
