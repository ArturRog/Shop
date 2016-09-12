package com.rog.webshop.model.order;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 7901837602811013572L;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String doorNo;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String streetName;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String areaName;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String state;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String country;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String zipCode;





    @Override
    public String toString() {
        return "Address{" +
                "doorNo='" + doorNo + '\'' +
                ", streetName='" + streetName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (doorNo != null ? !doorNo.equals(address.doorNo) : address.doorNo != null) return false;
        if (streetName != null ? !streetName.equals(address.streetName) : address.streetName != null) return false;
        if (areaName != null ? !areaName.equals(address.areaName) : address.areaName != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        return zipCode != null ? zipCode.equals(address.zipCode) : address.zipCode == null;

    }

    @Override
    public int hashCode() {
        int result = doorNo != null ? doorNo.hashCode() : 0;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
