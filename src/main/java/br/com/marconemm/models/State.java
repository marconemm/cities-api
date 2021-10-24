package br.com.marconemm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "states")
public class State {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(length = 60)
    private String name;

    @Column(length = 60)
    private String state;

    private Integer ibge_code;

    private Integer country_id;

    @Column(length = 28)
    private String ddd;

    public State() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIbge_code() {
        return ibge_code;
    }

    public void setIbge_code(Integer ibge_code) {
        this.ibge_code = ibge_code;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State states = (State) o;
        return id.equals(states.id) && name.equals(states.name) && state.equals(states.state) && ibge_code.equals(states.ibge_code) && country_id.equals(states.country_id) && ddd.equals(states.ddd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, ibge_code, country_id, ddd);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", ibge_code=" + ibge_code +
                ", country_id=" + country_id +
                ", ddd='" + ddd + '\'' +
                '}';
    }
}
