package com.example.springproject.orders;

import java.util.*;

public class Stock {

   private ArrayList<Product> productList;
   private ArrayList<Integer> quantityInStock;

   public Stock() {
      productList=new ArrayList<Product>();
      quantityInStock=new ArrayList<Integer>();
   }

   public void addProduct(Product p,int quantity){
      int ok=0;
      for (int i=0;i<productList.size();i++){
         if (productList.get(i).getId() == p.getId()) {
            quantityInStock.set(i, quantityInStock.get(i) + quantity);
            ok=1;
         }
      }
      if(ok==0){
         productList.add(p);
         quantityInStock.add(quantity);
      }
   }

   public void modifyQuantity(int productID,int newQuantity){
      for (int i=0;i<productList.size();i++){
         if (productList.get(i).getId() == productID){
            quantityInStock.set(i,newQuantity);
            break;
         }
      }
   }

   public void removeProduct(int productID){
      for (int i=0;i<productList.size();i++){
         if (productList.get(i).getId() == productID){
            productList.remove(i);
            quantityInStock.remove(i);
            break;
         }
      }
   }

   public int getStock(int productID) {
      for (int i = 0; i < productList.size(); i++) {
         if (productList.get(i).getId() == productID) {
            return productList.get(i).getQuantity();
         }
      }
      return 0;
   }

}