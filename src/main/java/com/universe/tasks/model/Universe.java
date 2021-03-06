package com.universe.tasks.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "universe", catalog = "tasks")
public class Universe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "universe_id")
    @ApiModelProperty(notes = "Universe id auto-generated")
    private int universeId;

    @Column(name = "universe_name")
    @NotNull
    @ApiModelProperty(notes = "Universe name")
    private String universeName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "universe_id", referencedColumnName = "universe_id")
    private List<Family> families;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "universe_id", referencedColumnName = "universe_id")
    private List<Person> persons;

    public int getUniverseId() {
        return universeId;
    }

    public void setUniverseId(int universeId) {
        this.universeId = universeId;
    }

    public String getUniverseName() {
        return universeName;
    }

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Universe() {
    }

    public Universe(int universeId, @NotNull String universeName, List<Family> families, List<Person> persons) {
        this.universeId = universeId;
        this.universeName = universeName;
        this.families = families;
        this.persons = persons;
    }
}

