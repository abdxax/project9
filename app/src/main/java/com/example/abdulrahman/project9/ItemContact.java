package com.example.abdulrahman.project9;

public class ItemContact {
    public static final String DBName = "Item";
    public final static String DBTable = "Product";
    public final static String CoulnID = "id";
    public final static String CoulnItemName = "name";
    public final static String Coulnprice = "price";
    public final static String CoulnIQuantity = "quantity";
    public final static String CoulnIproductSupplierName = "productSupplierName";
    public final static String CoulnIproductSupplierPhone = "productSupplierPhone";
    public final static int version = 1;
    public final static String CreateDB = "create table " + DBTable + "(" + CoulnID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CoulnItemName + " TEXT NOT NULL," + Coulnprice + " INTEGER DEFAULT 0," + CoulnIQuantity + " INTEGER DEFAULT 0," +
            CoulnIproductSupplierName + " TEXT," + CoulnIproductSupplierPhone + " INTEGER);";


}
