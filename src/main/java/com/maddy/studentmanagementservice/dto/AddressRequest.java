package com.maddy.studentmanagementservice.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressRequest {

    @NotBlank(message = "Street Name shouldn't be null or empty")
    private String streetName;

    @NotBlank(message = "City shouldn't be null or empty")
    private String city;

    @NotBlank(message = "Province shouldn't be null or empty")
    private String province;

    @NotBlank(message = "Country shouldn't be null or empty")
    private String country;

    @NotBlank(message = "PinCode shouldn't be null or empty")
    private String pinCode;

    public AddressRequest() {

    }

    public AddressRequest(String streetName, String city, String province, String country, String pinCode) {
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.country = country;
        this.pinCode = pinCode;
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
