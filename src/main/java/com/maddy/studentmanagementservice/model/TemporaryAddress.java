package com.maddy.studentmanagementservice.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "temporaryAddress")
public class TemporaryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temp_add_id")
    public long addressId;

    @Column(name = "streetName")
    private String streetName;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

    @Column(name = "pinCode")
    private String pinCode;

    public TemporaryAddress() {

    }

    public TemporaryAddress(String streetName, String city, String province, String country, String pinCode) {
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.country = country;
        this.pinCode = pinCode;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
