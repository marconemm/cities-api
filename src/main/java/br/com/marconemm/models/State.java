package br.com.marconemm.models;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ArrayList<Integer> getDdd() {
        final String[] strList = ddd.substring(1, ddd.length() -1).split(",");
        final ArrayList<Integer> result =new ArrayList<Integer>();

        for (String s : strList) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }

    public void setDdd(ArrayList<Integer> ddd) {
        if (ddd != null){
            this.ddd = ddd.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State states = (State) o;
        return id.equals(states.id) && name.equals(states.name) && state.equals(states.state) && ibge_code.equals(states.ibge_code) && country.equals(states.country) && ddd.equals(states.ddd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state, ibge_code, country, ddd);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", ibge_code=" + ibge_code +
                ", country_id=" + country +
                ", ddd='" + ddd + '\'' +
                '}';
    }
}
