package com.khalej.hoguzatadmin.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class contact_category_realm extends RealmObject {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("nameca")
    String nameca;
    @SerializedName("offer")
    String offer;
    @SerializedName("lat")
    Double lat;
    @SerializedName("lng")
    Double lng;
    @SerializedName("details")
    String detail;
    @SerializedName("image")
    String image;
    @SerializedName("city")
    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNameca() {
        return nameca;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNameca(String nameca) {
        this.nameca = nameca;
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


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
