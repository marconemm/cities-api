package br.com.marconemm.models;

import br.com.marconemm.utils.PointType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "cities")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(length = 120)
    private String name;

    @Column(length = 120, name = "ibge_code")
    private String codeIBGE;

    private Double latitude;
    private Double longitude;

    @Column(name = "lat_lon")
    @Type(type = "point")
    private Point geoLoc;

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

    public String getCodeIBGE() {
        return codeIBGE;
    }

    public void setCodeIBGE(String codeIBGE) {
        this.codeIBGE = codeIBGE;
    }

    public Point getGeoLoc() {
        return geoLoc;
    }

    public void setGeoLoc(Point geoLoc) {
        this.geoLoc = geoLoc;
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
