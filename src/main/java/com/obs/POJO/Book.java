package com.obs.POJO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_BOOK")
public class Book {
    @Id
    @Column(name = "id")
    private String id;

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //    private String name;
//    private String author;
//    private double price;
//    private String coverImage;
//    private String description;
//    private int categoryId;
//    private int stock;
//    private int sales;



}
