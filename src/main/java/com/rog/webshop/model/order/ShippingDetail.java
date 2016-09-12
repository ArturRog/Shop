package com.rog.webshop.model.order;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class ShippingDetail implements Serializable {


    private static final long serialVersionUID = 598734471727299693L;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String name;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;


    private Address shippingAddress;


    public ShippingDetail() {
        this.shippingAddress = new Address();
    }

    @Override
    public String toString() {
        return "ShippingDetail{" +
                "name='" + name + '\'' +
                ", shippingDate=" + shippingDate +
                ", shippingAddress=" + shippingAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingDetail that = (ShippingDetail) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shippingDate != null ? !shippingDate.equals(that.shippingDate) : that.shippingDate != null) return false;
        return shippingAddress != null ? shippingAddress.equals(that.shippingAddress) : that.shippingAddress == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (shippingDate != null ? shippingDate.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        return result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
