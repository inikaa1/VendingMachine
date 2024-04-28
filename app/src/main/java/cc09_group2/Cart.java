package cc09_group2;

import java.io.File;
import java.io.FileWriter;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
    Customer customer = new Customer("app/CustomerInfo.csv");

    
    public void addItem(Snacks snack) {
        customer.cart.add(snack);
    }


    public void removeItem(Snacks snack) {
        customer.cart.remove(snack);
    }

    public void emptyCart() {
        for (int i = 0; i < customer.cart.size(); i++) {
            removeItem(customer.cart.get(i));
        }
    }
 

    public void displayCart() {
        System.out.println("CART: ");
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %-8s |%n", "CODE", "ITEM NAME", "PRICE");
        System.out.printf("------------------------------------------%n");
        for(int i = 0; i < customer.cart.size(); i++) {
            System.out.printf("| %4s | %-20s | %-8.2f |%n", customer.cart.get(i).itemCode, customer.cart.get(i).itemName, customer.cart.get(i).itemPrice);
        }
        System.out.printf("------------------------------------------%n");
    }

    // public void transactionHistory() {
    //     ArrayList<String> list = new ArrayList<>();
    //     Collections.addAll(customer.cart,list);
    //     countFrequencies(customer.cart);
    // }

    // public static void countFrequencies(List<Snacks> cart){
    //     Map<String, Integer> hm = new HashMap<>();
    //     for(Snacks snacks : cart){
    //         Integer j = hm.get(snacks);
    //         hm.put(snacks,(j==null)?1:j+1);

    //     }
    //     for(Entry<String,Integer> val : hm.entrySet()){
    //         System.out.println("element:"+val.getKey()+" "+"occurs"+": " +val.getValue()+" times");
    //     }
        
    // }

    public float getTotal() {
        float total = 0;
        for(int i = 0; i < customer.cart.size(); i++) {
            total = total + customer.cart.get(i).itemPrice;
        }
        return total;
    }

    public int getSize() {
        return customer.cart.size();
    }

}
