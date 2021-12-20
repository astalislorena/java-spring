package com.example.springproject.orders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private int id;
    private ArrayList<Product> productList;
    private ArrayList<Integer> quantityAdded;
    private String orderStatus;
    private float price;
    private Date date;
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");;

    public Order(int id, ArrayList<Product> productList, ArrayList<Integer> quantityAdded, float price) {
        this.id = id;
        this.productList = productList;
        this.quantityAdded = quantityAdded;
        this.price = price;
        this.orderStatus="New order";
        date = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Integer> getQuantityAdded() {
        return quantityAdded;
    }

    public void setQuantityAdded(ArrayList<Integer> quantityAdded) {
        this.quantityAdded = quantityAdded;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public String getFormattedDate(){
        return formatter.format(date);
    }

    public void changeStatus(String s){
        this.orderStatus=s;
    }

    public void addProduct(Product p,int quantity){
        int ok=0;
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId() == p.getId()) {
                quantityAdded.set(i, quantityAdded.get(i) + quantity);
                price=price+p.getPrice();
                ok=1;
            }
        }
        if(ok==0){
            productList.add(p);
            quantityAdded.add(quantity);
        }
    }

    public void removeProduct(int productID){
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId() == productID){
                price=price-productList.get(i).getPrice()*quantityAdded.get(i);
                productList.remove(i);
                quantityAdded.remove(i);
                break;
            }
        }
    }

    public void modifyQuantity(int productID,int newQuantity){
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId() == productID){
                price=price-productList.get(i).getPrice()*(quantityAdded.get(i)-newQuantity);
                quantityAdded.set(i,newQuantity);
                break;
            }
        }
    }
}