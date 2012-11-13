package de.crowdcode.vehicle.domain;

import java.net.URL;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

@Entity
@NamedQueries(value={
    @NamedQuery(name="vehicleFindAll", query="SELECT v FROM Vehicle v"),
    @NamedQuery(name="vehicleFindByManufacturerName", query="SELECT v FROM Vehicle v WHERE v.manufacturer.name = :name"),
    @NamedQuery(name="vehicleByEngineType", query="SELECT v FROM Vehicle v WHERE v.engine.type = :engineType"),
    @NamedQuery(name="vehicleFindCheapest", query="SELECT v FROM Vehicle v WHERE v.nettoPrice = (SELECT min(v.nettoPrice) FROM Vehicle v)")
    
})
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    private Manufacturer manufacturer;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Engine engine;
    
    private String model;
    private Double nettoPrice;
    private Date constructionDate;

    private int kilometres;

    private URL smallImageURL;
    private URL normalImageURL;
    
    @Version 
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(Double nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public Date getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public int getKilometres() {
        return kilometres;
    }

    public void setKilometres(int kilometres) {
        this.kilometres = kilometres;
    }

    public URL getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(URL smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public URL getNormalImageURL() {
        return normalImageURL;
    }

    public void setNormalImageURL(URL normalImageURL) {
        this.normalImageURL = normalImageURL;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

}
