package domain;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name="Heater.findAll",
                query="select h from Heater h"),
        @NamedQuery(
                name="Heater.findById",
                query="select h from Heater h where h.idHeater = :id")
})
@Entity
public class Heater extends SmartPeripheric{
    int idHeater;
    int power;
    Home residence;

    public Heater() {
        super();
    }

    @Id
    @GeneratedValue
    @Column(name="HEATER_ID")
    public int getIdHeater() {
        return idHeater;
    }

    public void setIdHeater(int idHeater) {
        this.idHeater = idHeater;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getConsommation() {
        return super.getConsomation();
    }

    public void setConsommation(int consommation) { super.setConsomation(consommation); }

    @ManyToOne
    @JoinColumn(name="HOME_HEATER", referencedColumnName="HOME_ID")
    public Home getResidence() {
        return residence;
    }

    public void setResidence(Home residence) {
        this.residence = residence;
    }

}

