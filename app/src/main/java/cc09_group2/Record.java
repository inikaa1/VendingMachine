package cc09_group2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;


public class Record {
    public static void recordCash(List<Snacks> items,double in, double change){
      File file = new File("transactionHistory.csv");
      Calendar date = Calendar.getInstance();
      String item_string = "";
      for (Snacks item: items){
        if (item_string.equals("")){
          item_string = item.itemName;
        }else{

          item_string = item_string+"+"+item.itemName;
        }
      }
      try {
          FileWriter fw = new FileWriter(file, true);
          fw.write(date.get(Calendar.SECOND) +","+ date.get(Calendar.MINUTE) +","+ date.get(Calendar.HOUR_OF_DAY)+","+date.get(Calendar.DATE)+","+date.get(Calendar.MONTH)+","+date.get(Calendar.YEAR)+","
          +item_string+","+in+","+change+"\n");
          fw.flush();
          fw.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
    }

    public static void recordCard(List<Snacks> items,String card_number){
      File file = new File("transactionHistory.csv");
      Calendar date = Calendar.getInstance();
      String item_string = "";
      for (Snacks item: items){
        if (item_string.equals("")){
          item_string = item.itemName;
        }else{
          item_string = item_string+"+"+item.itemName;
        }
      }

      try {
          FileWriter fw = new FileWriter(file, true);
          fw.write(date.get(Calendar.SECOND) +","+ date.get(Calendar.MINUTE) +","+ date.get(Calendar.HOUR_OF_DAY)+","+date.get(Calendar.DATE)+","+date.get(Calendar.MONTH)+","+date.get(Calendar.YEAR)+","
          +item_string+","+card_number+"\n");
          fw.flush();
          fw.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
    }

    public static void printTransaction(){
      try {
         Scanner scanner = new Scanner(new File("transactionHistory.csv"));
         while (scanner.hasNextLine()) {
            String[] l = scanner.nextLine().split(",");
            if (l.length == 8){
              System.out.println(l[0]+":"+l[1]+":"+l[2]+"-"+l[3]+"/"+l[4]+"/"+l[5]+"||Card: "+l[7]+"||"+l[6]);
            }else{
              System.out.println(l[0]+":"+l[1]+":"+l[2]+"-"+l[3]+"/"+l[4]+"/"+l[5]+"||Cash: "+l[7]+", change: "+l[8]+"||"+l[6]);
            }
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
    }
}
