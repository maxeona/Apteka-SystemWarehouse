package com.example.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "directory")
public class DirectoryForRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_sprav;
    @Column(name = "index")
    private String index;
    @Column(name = "type")
    private String type;
    @Column(name = "term_izg")
    private int term_izg;
    @Column(name = "term_srok")
    private int term_srok;
    @Column(name = "price")
    private int price;
    @OneToMany(mappedBy = "directory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ComponentForRecipes>listComponent=new ArrayList<>();




    public DirectoryForRecipe(){}

    public Long getId_sprav() {
        return id_sprav;
    }

    public void setId_sprav(Long id_sprav) {
        this.id_sprav = id_sprav;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTerm_izg() {
        return term_izg;
    }

    public void setTerm_izg(int term_izg) {
        this.term_izg = term_izg;
    }

    public int getTerm_srok() {
        return term_srok;
    }

    public void setTerm_srok(int term_srok) {
        this.term_srok = term_srok;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<ComponentForRecipes> getListComponent() {
        return listComponent;
    }

    public void setListComponent(List<ComponentForRecipes> listComponent) {
        this.listComponent = listComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectoryForRecipe that = (DirectoryForRecipe) o;
        return term_izg == that.term_izg &&
                term_srok == that.term_srok &&
                price == that.price &&
                Objects.equals(id_sprav, that.id_sprav) &&
                Objects.equals(index, that.index) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_sprav, index, type, term_izg, term_srok, price);
    }
}
