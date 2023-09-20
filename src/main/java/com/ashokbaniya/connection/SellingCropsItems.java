package com.ashokbaniya.connection;

public class SellingCropsItems {
    private String imageResource;
    private String itemName;

    private String itemPrice;

    private String itemQuantity;

    public SellingCropsItems(String imageResource, String itemName, String itemPrice, String itemQuantity) {
        this.imageResource = imageResource;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public String getImageResource() {
        return imageResource;
    }

    public String getItemName() {
        return itemName;
    }
    public String getItemPrice() {
        return itemPrice;
    }
    public String getItemQuantity() {
        return itemQuantity;
    }
}