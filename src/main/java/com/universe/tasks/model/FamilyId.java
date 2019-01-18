package com.universe.tasks.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class FamilyId implements Serializable {

    @Column(name = "family_id")
    private int familyId;

    @Column(name = "universe_id")
    private int universeId;

    public FamilyId() {
    }

    public FamilyId(int familyId, int universeId) {
        this.familyId = familyId;
        this.universeId = universeId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public int getUniverseId() {
        return universeId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FamilyId{");
        sb.append("familyId='").append(familyId).append('\'');
        sb.append(", universeId='").append(universeId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyId)) return false;
        FamilyId that = (FamilyId) o;
        return Objects.equals(getUniverseId(), that.getUniverseId()) &&
                Objects.equals(getFamilyId(), that.getFamilyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniverseId(), getFamilyId());
    }
}