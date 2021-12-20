package com.example.springproject.orders;

import java.util.ArrayList;

public class Cart {

    private int id;
    private ArrayList<Product> productList;
    private ArrayList<Integer> quantityAdded;
    float price;

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

    //adds products and updates quantity
    //auto increment for price

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
