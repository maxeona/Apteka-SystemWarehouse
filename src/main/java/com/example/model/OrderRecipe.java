package com.example.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orderecipe")
public class OrderRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_order;
    @Column(name = "index")
    private String index;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "email")
    private String email;
    @Column(name = "number")
    private String number;
    @Column(name="status")
    private String status;

    public OrderRecipe(){}

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId_order() {
        return id_order;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getIndex() {
        return index;
    }

    public String getNumber() {
        return number;
    }

    public String getPatronymic() {
        return patronymic;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRecipe that = (OrderRecipe) o;
        return Objects.equals(id_order, that.id_order) &&
                Objects.equals(index, that.index) &&
                Objects.equals(first_name, that.first_name) &&
                Objects.equals(last_name, that.last_name) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(email, that.email) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_order, index, first_name, last_name, patronymic, email, number);
    }
}
