package cc09_group2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Snacks {
    String itemName;
    int itemCode;
    String itemCategory;
    int itemQuantity;
    float itemPrice;
    float itemSold;
    public static List<Snacks> allSnacks = new ArrayList<>();
    public  static List<Snacks> soldList = new ArrayList<>();

    public Snacks() {

    }

    public Snacks(String itemName, int itemCode, String itemCategory, int itemQuantity, float itemPrice) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.itemCategory = itemCategory;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        itemSold = 0;
        allSnacks.add(this);

    }

    public static void displayDrinks() {
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %-8s |%n", "CODE", "ITEM NAME", "PRICE");
        System.out.printf("------------------------------------------%n");
        for (int i = 0; i < allSnacks.size(); i++) {
            if (allSnacks.get(i).itemCategory.equals("drinks")) {
                System.out.printf("| %4s | %-20s | %-8.2f |%n", allSnacks.get(i).itemCode, allSnacks.get(i).itemName, (double) Math.round(allSnacks.get(i).itemPrice * 100.0)/100.0);
            }
        }
        System.out.printf("------------------------------------------%n");
    }

    public static void displayChocolates() {
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %-8s |%n", "CODE", "ITEM NAME", "PRICE");
        System.out.printf("------------------------------------------%n");
        for (int i = 0; i < allSnacks.size(); i++) {
            if (allSnacks.get(i).itemCategory.equals("chocolates")) {
                System.out.printf("| %4s | %-20s | %-8.2f |%n", allSnacks.get(i).itemCode, allSnacks.get(i).itemName,(double) Math.round(allSnacks.get(i).itemPrice * 100.0)/100.0);
            }
        }
        System.out.printf("------------------------------------------%n");
    }

    public static void displayChips() {
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %-8s |%n", "CODE", "ITEM NAME", "PRICE");
        System.out.printf("------------------------------------------%n");
        for (int i = 0; i < allSnacks.size(); i++) {
            if (allSnacks.get(i).itemCategory.equals("chips")) {
                System.out.printf("| %4s | %-20s | %-8.2f |%n", allSnacks.get(i).itemCode, allSnacks.get(i).itemName, (double) Math.round(allSnacks.get(i).itemPrice * 100.0)/100.0);
            }
        }
        System.out.printf("------------------------------------------%n");
    }

    public static void displayCandies() {
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %4s | %-20s | %-8s |%n", "CODE", "ITEM NAME", "PRICE");
        System.out.printf("------------------------------------------%n");
        for (int i = 0; i < allSnacks.size(); i++) {
            if (allSnacks.get(i).itemCategory.equals("candies")) {
                System.out.printf("| %4s | %-20s | %-8.2f |%n", allSnacks.get(i).itemCode, allSnacks.get(i).itemName, (double) Math.round(allSnacks.get(i).itemPrice * 100.0)/100.0);
            }
        }
        System.out.printf("------------------------------------------%n");
    }

    public Boolean checkQuantity() {
        if (itemQuantity >= 15) {
            return true;
        }
        if (itemQuantity == 0) {
            return false;
        } else {
            return false;
        }
    }

    public static void SnackRemove(int code, Cart cart) {
        for (int i = 0; i < allSnacks.size(); i++) {
            if (allSnacks.get(i).itemCode == code) {
                cart.removeItem(allSnacks.get(i));
                System.out.println("You have removed a " + allSnacks.get(i).itemName + " from your cart");
            }
        }
    }

    public static void getObjectByCode(int code, Cart cart) {
        for (int i = 0; i < allSnacks.size(); i++) {
            if (allSnacks.get(i).itemCode == code) {
                System.out.println("You have added a " + allSnacks.get(i).itemName + " to your cart");
                cart.addItem(allSnacks.get(i));
            }
        }
    }

    
    public String getSnackName() {
        return this.itemName;
    }

    public String getSnackCode() {
        return Integer.toString(this.itemCode);
    }

    public String getSnackCategory() {
        return this.itemCategory;
    }

    public String getSnackQuantity() {
        return Integer.toString(this.itemQuantity);
    }

    public String getSnackPrice() {
        return Float.toString(this.itemPrice);
    }

    // WORKS
    public static List<Snacks> readSnacksFromCSV(String fileName) {
        List<Snacks> snackslist = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                Snacks ss = createSnack(attributes);
                snackslist.add(ss);
                line = br.readLine();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return snackslist;
    }

    // WORKS1
    public static Snacks createSnack(String[] metadata) {
        String name = metadata[0];
        int code = Integer.parseInt(metadata[1]);
        String category = metadata[2];
        int quantity = Integer.parseInt(metadata[3]);
        float price = Float.parseFloat(metadata[4]);

        return new Snacks(name, code, category, quantity, price);
    }

}
