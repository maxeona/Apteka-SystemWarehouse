package com.example.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "medicine")
public class Medicine
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "application")
    private String application;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(name = "data_start")
    private Date data_start;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(name = "data_finish")
    private Date data_finish;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "status")
    private String status;
    @Column(name="name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "quantity")
    private int quantity;

    public Medicine(){}

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public void setData_finish(Date data_finish) { this.data_finish = data_finish; }

    public Date getData_start() { return data_start; }

    public void setData_start(Date data_start) { this.data_start = data_start; }

    public Date getData_finish() { return data_finish; }

    public String getApplication() { return application; }

    public String getManufacturer() { return manufacturer; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApplication(String application) { this.application = application; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id) &&

                Objects.equals(type, medicine.type) &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(application, medicine.application) &&
                Objects.equals(data_start, medicine.data_start) &&
                Objects.equals(data_finish, medicine.data_finish) &&
                Objects.equals(manufacturer, medicine.manufacturer);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, type, name,  application, data_start, data_finish, manufacturer);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", Наименование='" + '\'' +
                ", Тип='" + type + '\'' +
                ", Применение='" + application + '\'' +
                ", Дата изготовления=" + data_start +
                ", Срок=" + data_finish +
                ", Производитель='" + manufacturer + '\'' +
                '}';
    }
}
