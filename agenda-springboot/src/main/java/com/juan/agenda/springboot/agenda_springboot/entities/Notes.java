package com.juan.agenda.springboot.agenda_springboot.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotes")
    private Long idNotes;

    private String name;
    private String description;
    private boolean active;

    @ManyToMany
    @JoinTable(
        name = "notes_days",
        joinColumns = @JoinColumn(name = "notes"),
        inverseJoinColumns = @JoinColumn(name = "days")
    )
    private List<Days> days;

    @PrePersist
    public void PrePersist(){
        active = true;
    }

    public Notes() {
    }

    public Long getIdNotes() {
        return idNotes;
    }
    
    public void setIdNotes(Long idNotes) {
        this.idNotes = idNotes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
