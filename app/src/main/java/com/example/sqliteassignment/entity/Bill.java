package com.example.sqliteassignment.entity;

import java.util.Date;

public class Bill {
    private String name;
    private String description;
    private String detail;
    private double price;
    private Date date;
    private String category;

    public Bill(String name, String description, String detail, double price, Date date, String category) {
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.price = price;
        this.date = date;
        this.category = category;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
