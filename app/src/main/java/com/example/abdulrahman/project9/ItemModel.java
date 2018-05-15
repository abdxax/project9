package com.example.abdulrahman.project9;

public class ItemModel {
    private int ID;
    private String ItemName;
    private int Price;
    private int Quantity;
    private String productSupplierName;
    private int productSupplierPhone;

    public ItemModel(int ID, String itemName, int price, int quantity, String productSupplierName, int productSupplierPhone) {
        this.ID = ID;
        ItemName = itemName;
        Price = price;
        Quantity = quantity;
        this.productSupplierName = productSupplierName;
        this.productSupplierPhone = productSupplierPhone;
    }

    public int getID() {
        return ID;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getProductSupplierName() {
        return productSupplierName;
    }

    public int getProductSupplierPhone() {
        return productSupplierPhone;
    }
}
