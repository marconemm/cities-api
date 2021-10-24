package br.com.marconemm.models;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(length = 120)
    private String name;

    @Column(length = 120, name = "ibge_code")
    private String ibgeCode;

    private Double latitude;
    private Double longitude;

    @Column(name = "cod_tom")
    private Short codTom;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(String ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Short getCodTom() {
        return codTom;
    }

    public void setCodTom(Short codTom) {
        this.codTom = codTom;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
