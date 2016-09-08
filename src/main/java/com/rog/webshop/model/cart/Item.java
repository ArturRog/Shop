package com.rog.webshop.model.cart;

import com.rog.webshop.model.product.Product;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable {


    private static final long serialVersionUID = 1503029612197381427L;
    private Product product;
    private Integer quantity;
    private BigDecimal totalValue;


    public Item(){
        this.quantity = 1;
    }

    public Item(Product product){
        this.quantity = 1;
        this.product = product;
    }

    public Item(Product product, Integer quantity){
        this.quantity = quantity;
        this.product = product;
    }



    public BigDecimal getTotalValue() {
        return this.product.getProductPrice().multiply(new BigDecimal(this.quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", totalValue=" + totalValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (product != null ? !product.equals(item.product) : item.product != null) return false;
        if (quantity != null ? !quantity.equals(item.quantity) : item.quantity != null) return false;
        return totalValue != null ? totalValue.equals(item.totalValue) : item.totalValue == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (totalValue != null ? totalValue.hashCode() : 0);
        return result;
    }
}
