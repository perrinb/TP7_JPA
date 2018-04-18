package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Home {
    int idHome;
    int nbRoom;
    int size;
    Collection<Person> owners = new ArrayList<Person>();
    Collection<Heater> heaters = new ArrayList<Heater>();
    Collection<ElectronicDevice> electronicDevices = new ArrayList<ElectronicDevice>();

    public Home() {
    }

    @Id
    @GeneratedValue
    @Column(name="HOME_ID")
    public int getIdHome() {
        return idHome;
    }

    public void setIdHome(int idHome) {
        this.idHome = idHome;
    }

    public int getNbRoom() {
        return nbRoom;
    }

    public void setNbRoom(int nbRoom) {
        this.nbRoom = nbRoom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @ManyToMany(mappedBy="residences")
    @JsonIgnore
    public Collection<Person> getOwners() {
        return owners;
    }

    public void setOwners(Collection<Person> owners) {
        this.owners = owners;
    }

    @OneToMany(mappedBy = "residence")
    @JsonIgnore
    public Collection<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(Collection<Heater> heaters) {
        this.heaters = heaters;
    }

    @OneToMany(mappedBy = "residence")
    @JsonIgnore
    public Collection<ElectronicDevice> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Collection<ElectronicDevice> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    @Override
    public String toString() {
        return "Home [id = " + idHome + ", size = " + size + ", number of rooms = " + nbRoom + "]";
    }
}
