package com.khalej.hoguzatadmin.model;

import com.google.gson.annotations.SerializedName;

public class contact_order {
    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;
    @SerializedName("date")
    String date;
    @SerializedName("phone")
    String phone;
    @SerializedName("address")
    String address;
    @SerializedName("details")
    String details;
    @SerializedName("price")
    double price;
    @SerializedName("charge")
    String charge;
    @SerializedName("Mandop")
    String mandop;
    @SerializedName("lat")
    double lat;
    @SerializedName("lng")
    double lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getMandop() {
        return mandop;
    }

    public void setMandop(String mandop) {
        this.mandop = mandop;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
