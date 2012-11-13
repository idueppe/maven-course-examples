package de.crowdcode.vehicle.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "findManufacturerByName", query = "SELECT m FROM Manufacturer m WHERE m.name = :name"),
})
public class Manufacturer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.MERGE })
    private List<Vehicle> vehicles = new ArrayList<>();
    
    @OneToMany(mappedBy = "manufacturer", cascade = { CascadeType.ALL})
    private List<Engine> ownedEngines = new ArrayList<>();

    @Version
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicle.setManufacturer(this);
            vehicles.add(vehicle);
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Manufacturer other = (Manufacturer) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public List<Engine> getOwnedEngines() {
        return ownedEngines;
    }

    public void setOwnedEngines(List<Engine> engines) {
        this.ownedEngines = engines;
    }

}
