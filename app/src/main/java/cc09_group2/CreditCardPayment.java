package cc09_group2;

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CreditCardPayment {

    public static boolean check(String name, String number) {

        JSONParser parser = new JSONParser();

        try {
            JSONArray array = (JSONArray) parser.parse(new FileReader("app/credit_cards.json"));
            for (Object i : array) {
                JSONObject obj = (JSONObject) i;
                if (obj.get("name").equals(name) && obj.get("number").equals(number)) {
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public static void saveCard(String username, String cardHolder, String cardNum) {
        File file = new File("SavedCreditCard.csv");
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(username + "," + cardHolder + "," + cardNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean checkUser(String username) {
        try {
            Scanner sc = new Scanner(new File("app/SavedCreditCard.csv"));

            while (sc.hasNextLine()) {
                String[] cardInfo = sc.nextLine().split(",");
                if (cardInfo[0].equals(username)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String[] getCardInfo(String username) {

        String[] array = new String[2];
        try {
            Scanner sc = new Scanner(new File("app/SavedCreditCard.csv"));

            while (sc.hasNextLine()) {
                String[] cardInfo = sc.nextLine().split(",");
                if (cardInfo[0].equals(username)) {
                    array[0] = cardInfo[1];
                    array[1] = cardInfo[2];
                }
//                return array;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }
}
