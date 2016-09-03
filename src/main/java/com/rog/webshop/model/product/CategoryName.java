package com.rog.webshop.model.product;

public enum CategoryName {

    PROTEINS("PROTEINS"),
    CREATINE("CREATINE"),
    AMINO_ACIDS("AMINO_ACIDS"),
    ACCESSORIES("ACCESSORIES");

    String categoryName;

    private CategoryName(String categoryName){
        this.categoryName =categoryName;
    }

    public String getCategoryName(){return categoryName;}

}
