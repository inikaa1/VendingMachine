package cc09_group2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class CashPayment {
    private String path;

    public int[] denominations = { 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000 };

    public CashPayment(String path) {
        this.path=path;
    }

    public void updateFile(int[] out) {
        File file = new File(this.path);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(out[0]+","+out[1]+","+out[2]+","+out[3]+","+out[4]+","+out[5]+","+out[6]+","+out[7]+","+out[8]+","+out[9]+","+out[10]);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] readFile() {
       int[] cash  = new int[11];
       try {
          Scanner scanner = new Scanner(new File(this.path));
          int index=0;
          String[] temp = scanner.nextLine().split(",");
          for (String i: temp){
            cash[index] = Integer.parseInt(i);
            index++;
          }
       } catch (FileNotFoundException e) {
          e.printStackTrace();
       }
       return cash;
    }

    private ArrayList<Double> get_change(double total, double cash_in){
      int remain = ((int)(cash_in*100)) - ((int)(total*100));
      int[] quantity = this.readFile();
      int i = quantity.length - 1;
      ArrayList<Double> output = new ArrayList<Double>();

      while(i!=-1 && remain > 0){
         if (remain >= (denominations[i]) && quantity[i]>0){
           remain-=denominations[i];
           output.add(denominations[i]/100.0);
           quantity[i] = quantity[i] - 1;
           if (remain == 0){
             return output;
           }
         }else{
           i--;
         }
       }
      ArrayList<Double> flag = new ArrayList<Double>();
      flag.add(-1.0);
      return flag;
    }

    public void addCash(int[] input){
      int[] old = this.readFile();
      for (int i=0;i<old.length;i++){
        old[i] += input[i];
      }
      this.updateFile(old);
    }

    public int find_index(double n){
      int value_in_cent = (int)(n*100);
    //   System.out.println(value_in_cent+ " find ind");
      for (int i=0 ; i<this.denominations.length ; i++){
        if (value_in_cent == this.denominations[i]){
          return i;
        }
      }
      return -1;
    }

    public ArrayList<Double> transaction(ArrayList<Double> in, double total){
        int[] add = new int[11];
        double cash_in = 0;
        for (Double i: in){
          cash_in+=i;
          add[this.find_index(i)]+=1;
        }
        if (this.get_change(total,cash_in).get(0)==-1){
            ArrayList<Double> empty_list = new ArrayList<Double>();
            return empty_list;
        }
  
        ArrayList<Double> change_back = this.get_change(total,cash_in);
        int[] deduct_cash = new int[11];
  
        for (Double i : change_back){
          add[this.find_index(i)]-=1;
        }
        this.addCash(add);
        //deduct cash in File
        return change_back;
    }

    public boolean valid_denomination(double input){
      return (this.find_index(input) != -1);
    }

    public boolean enough_cash_in(ArrayList<Double> in, double total){
      double cash_in = 0;
      for (Double i: in){
        cash_in+=i;
      }
      return (total <= cash_in);
    }

    public boolean enough_change(ArrayList<Double> in, double total) {
        double cash_in = 0;
        for (Double i : in) {
            cash_in += i;
        }
        if (cash_in == total) {
            return true;
        }
        return this.get_change(total, cash_in).get(0) != -1;
    }

    public void print_change(ArrayList<Double> change){
      for (double i: change){
        if (i < 1.0){
          int cent = (int) (i*100);
          System.out.println(cent + " cents");
        }else{
          int dollar = (int) i;
          System.out.println(dollar + " dollars");
        }
      }
    }

    public double getTotal(ArrayList<Double> cash_array) {
        double total_cash_in=0;
        for (Double i : cash_array){
            total_cash_in += i;
        }
        return total_cash_in;
    }

    

}