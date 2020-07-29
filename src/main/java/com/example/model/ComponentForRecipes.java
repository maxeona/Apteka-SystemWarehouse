package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "component")
public class ComponentForRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "term_godn")
    private int term_qodn;
    @Column(name = "status")
    private int status;
    @Column(name = "recipe_id")
    private Long recipe_id;
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false, insertable = false, updatable = false)
    private DirectoryForRecipe directory;



    public ComponentForRecipes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTerm_qodn() {
        return term_qodn;
    }

    public void setTerm_qodn(int term_qodn) {
        this.term_qodn = term_qodn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public DirectoryForRecipe getDirectory() {
        return directory;
    }

    public void setDirectory(DirectoryForRecipe directory) {
        this.directory = directory;
    }

    public Long getRecipe_id() { return recipe_id; }

    public void setRecipe_id(Long recipe_id) { this.recipe_id = recipe_id; }
}
