package com.universe.tasks.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonId implements Serializable {

    @Column(name = "person_id")
    private int personId;

    @Column(name = "universe_id")
    private int universeId;

    public PersonId() {
    }

    public PersonId(int personId, int universeId) {
        this.personId = personId;
        this.universeId = universeId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public int getUniverseId() {
        return universeId;
    }

    public void setUniverseId(int universeId) {
        this.universeId = universeId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PersonId{");
        sb.append("personId='").append(personId).append('\'');
        sb.append(", universeId='").append(universeId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonId)) return false;
        PersonId that = (PersonId) o;
        return Objects.equals(getUniverseId(), that.getUniverseId()) && Objects.equals(getPersonId(), that.getPersonId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniverseId(), getPersonId());
    }
}