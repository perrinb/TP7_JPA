package domain;

import javax.persistence.*;

@Entity
public class ElectronicDevice extends SmartPeripheric{
    int idElectronicDevice;
    String fonction;
    Home residence;

    public ElectronicDevice() {
        super();
    }

    @Id
    @GeneratedValue
    @Column(name="ED_ID")
    public int getIdElectronicDevice() {
        return idElectronicDevice;
    }

    public void setIdElectronicDevice(int idElectronicDevice) {
        this.idElectronicDevice = idElectronicDevice;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getConsommation() {
        return super.getConsomation();
    }

    public void setConsommation(int consommation) { super.setConsomation(consommation); }

    @ManyToOne
    @JoinColumn(name="HOME_ED", referencedColumnName="HOME_ID")
    public Home getResidence() {
        return residence;
    }

    public void setResidence(Home residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return "Device [id=" + idElectronicDevice + ", consomation =" + consomation + "]";
    }
}
