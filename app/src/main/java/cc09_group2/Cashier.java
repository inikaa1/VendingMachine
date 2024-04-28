package cc09_group2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class Cashier {
    private String cash_path;
    private String transaction_path;
    public Cashier(String cash_path){
        this.cash_path = cash_path;
        this.transaction_path= transaction_path;
    }


    public void change_report() {
        CashPayment n = new CashPayment(cash_path);
        int[] value = n.readFile();
        System.out.println("\n\t\tAVAILABLE CASH");
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %28s | %-12s|%n", "NOTE/COIN DENOMINATION", "QUANTITY");
        System.out.printf("----------------------------------------------%n");
        System.out.printf("| %28s | %-12s|%n", "5 cents", value[0]);
        System.out.printf("| %28s | %-12s|%n", "10 cents", value[1]);
        System.out.printf("| %28s | %-12s|%n", "20 cents", value[2]);
        System.out.printf("| %28s | %-12s|%n", "50 cents", value[3]);
        System.out.printf("| %28s | %-12s|%n", "1 dollar", value[4]);
        System.out.printf("| %28s | %-12s|%n", "2 dollar", value[5]);
        System.out.printf("| %28s | %-12s|%n", "5 dollars", value[6]);
        System.out.printf("| %28s | %-12s|%n", "10 dollars", value[7]);
        System.out.printf("| %28s | %-12s|%n", "20 dollars", value[8]);
        System.out.printf("| %28s | %-12s|%n", "50 dollars", value[9]);
        System.out.printf("| %28s | %-12s|%n", "100 dollars", value[10]);
        System.out.printf("----------------------------------------------%n");

    }

    public void modify_change(double denomination, int quantity){
        CashPayment n = new CashPayment(cash_path);
        int[] list = n.readFile();
        int index = n.find_index(denomination);
        list[index] = quantity;
        n.updateFile(list);
    }

    
    /////////////////////////false mean card//////////////0 for card///
    // public static void record(boolean cash,int itemsold,double change){
    
    // }
}
