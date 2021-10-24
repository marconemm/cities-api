package br.com.marconemm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(length = 60)
    private String name;

    @Column(name = "name_pt_br", length = 60)
    private String nameBr;

    @Column(length = 2)
    private String code;

    private Integer bacen;

    public Country() {
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

    public String getNameBr() {
        return nameBr;
    }

    public void setNameBr(String nameBr) {
        this.nameBr = nameBr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(name, country.name) && Objects.equals(nameBr, country.nameBr) && Objects.equals(code, country.code) && Objects.equals(bacen, country.bacen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nameBr, code, bacen);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameBr='" + nameBr + '\'' +
                ", code='" + code + '\'' +
                ", bacen=" + bacen +
                '}';
    }
}
