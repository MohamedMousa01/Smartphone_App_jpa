package it.smartphoneAppInJpa.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "smartphone")
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modello")
    private String modello;
    @Column(name = "prezzo")
    private int prezzo;
    @Column(name = "versioneos")
    private String versioneOS;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
    @JoinTable(name = "smartphone_app" , joinColumns = @JoinColumn(name = "smartphone_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "app_id" , referencedColumnName = "id"))
    private Set<App> apps = new HashSet<>();


    public Smartphone(){}

    public Smartphone(String marca, String modello, int prezzo, String versioneOS) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.versioneOS = versioneOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getVersioneOS() {
        return versioneOS;
    }

    public void setVersioneOS(String versioneOS) {
        this.versioneOS = versioneOS;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", prezzo=" + prezzo +
                ", versioneOS='" + versioneOS + '\'' +
                '}';
    }
}
