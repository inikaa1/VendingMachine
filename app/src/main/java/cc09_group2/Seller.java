package cc09_group2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Seller {
    int quantitysold;
    static List<Snacks> allSnacks = new ArrayList<>();
    List<Snacks> reportList = new ArrayList<>();
    String newname;
    String newcode;
    String newcategory;
    String newquantity;
    String newprice;

    public void displayitems() {
        allSnacks = Snacks.readSnacksFromCSV("SnacksInfo.csv");
        System.out.println("Avaliable items: ");
        System.out.printf("------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %-10s | %-8s | %-8s |%n", "CODE", "ITEM NAME", "CATEGORY", "QUANTITY",
                "PRICE");
        System.out.printf("------------------------------------------------------------------%n");
        for (int i = 0; i < allSnacks.size(); i++) {
            System.out.printf("| %4s | %-20s | %-10s | %-8s | %-8.2f |%n", allSnacks.get(i).itemCode,
                    allSnacks.get(i).itemName, allSnacks.get(i).itemCategory, allSnacks.get(i).itemQuantity,
                    allSnacks.get(i).itemPrice);
        }
        System.out.printf("------------------------------------------------------------------%n");
    }

    public void QuantityReport() {
        System.out.println("SELLER SOLD ITEMS REPORT");
        System.out.printf("------------------------------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %-10s | %-8s | %-8s |%n", "CODE", "ITEM NAME", "CATEGORY", "QUANTITY",
                "PRICE");
        System.out.printf("------------------------------------------------------------------%n");
        for (int i = 0; i < Snacks.soldList.size(); i++) {
            System.out.printf("| %4s | %-20s | %-10s | %-8s | %-8s |%n", Snacks.soldList.get(i).itemCode,
                    Snacks.soldList.get(i).itemName, Snacks.soldList.get(i).itemSold);
        }
        System.out.printf("------------------------------------------------------------------%n");
    }

   
    public static void edit(String filepath, String ediTerm, String newname, String newcode, String newCategory,
            String newQuantity, String newPrice) {
        String tempFile = "temp.csv";
        File oldF = new File(filepath);
        File newF = new File(tempFile);
        String name = "";
        String code = "";
        String category = "";
        String quantity = "";
        String price = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner x = new Scanner(new File(filepath));
            Snacks snacks;
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                String[] temp = x.nextLine().split(",");
                name = temp[0];
                code = temp[1];
                category = temp[2];
                quantity = temp[3];
                price = temp[4];

                if (name.equals(ediTerm)) {
                    pw.println(newname + "," + newcode + "," + newCategory + "," + newQuantity + "," + newPrice);
                } else {
                    pw.println(name + "," + code + "," + category + "," + quantity + "," + price);

                }

            }
            x.close();
            pw.flush();
            pw.close();
            oldF.delete();
            File dump = new File(filepath);
            newF.renameTo(dump);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
