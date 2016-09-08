package com.rog.webshop.model.product;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable{

    private static final long serialVersionUID = -6461657159577643747L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 4, max = 40, message = "{Size.Product.productName.validation}")
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Min(value = 0,    message = "{Min.Product.productPrice.validation}")
    @Digits(integer = 8,fraction = 2,message = "{Digits.Product.productPrice.validation}")
    @NotNull(message = "{NotNull.Product.productPrice.validation}")
    @Column(name = "PRODUCT_PRICE")
    private BigDecimal productPrice;

    @NotBlank(message = "{NotBlank.Product.productDescription.validation}")
    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @JsonIgnore
    @NotNull(message = "NotNull.Product.category.validation")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

//    private MultipartFile productImage;

    public Product() {
    }

    public Product(String productName, BigDecimal productPrice, String productDescription, Category category) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null)
            return false;
        if (productDescription != null ? !productDescription.equals(product.productDescription) : product.productDescription != null)
            return false;
        return category != null ? category.equals(product.category) : product.category == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", category=" + category +
                '}';
    }
}
