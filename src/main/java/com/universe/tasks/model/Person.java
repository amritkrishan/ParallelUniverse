package com.universe.tasks.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "person", catalog = "tasks")
public class Person {

    @Column(name = "power")
    @ApiModelProperty(notes = "Power")
    private String power;

    @EmbeddedId
    private PersonId compositeKey;

    @Column(name = "person_name")
    @ApiModelProperty(notes = "Person Name")
    private String personName;

    @Column(name = "family_id")
    @ApiModelProperty(notes = "Family id")
    private int familyId;


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public PersonId getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(PersonId compositeKey) {
        this.compositeKey = compositeKey;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public Person() {
    }

    public Person(String power, PersonId compositeKey, String personName, int familyId) {
        this.power = power;
        this.compositeKey = compositeKey;
        this.personName = personName;
        this.familyId = familyId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("compositeKey='").append(compositeKey).append('\'');
        sb.append(", personName='").append(personName).append('\'');
        sb.append(", familyId='").append(familyId).append('\'');
        sb.append(", power='").append(power).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
