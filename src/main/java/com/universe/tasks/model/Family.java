package com.universe.tasks.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "family", catalog = "tasks")
public class Family {

    @EmbeddedId
    private FamilyId compositeKey;

    @Column(name = "family_name")
    @NotNull
    @ApiModelProperty(notes = "Family Name")
    private String familyName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "family_id", referencedColumnName = "family_id"),
            @JoinColumn(name = "universe_id", referencedColumnName = "universe_id"),
    })
    private List<Person> persons;

    public Family() {
    }

    public Family(FamilyId compositeKey, @NotNull String familyName, List<Person> persons) {
        this.compositeKey = compositeKey;
        this.familyName = familyName;
        this.persons = persons;
    }

    public FamilyId getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(FamilyId compositeKey) {
        this.compositeKey = compositeKey;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Family{");
        sb.append("compositeKey='").append(compositeKey).append('\'');
        sb.append(", familyName='").append(familyName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
