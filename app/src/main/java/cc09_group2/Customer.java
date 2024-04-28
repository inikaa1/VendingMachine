package cc09_group2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String username;
    private char[] passwordArray;
    private String data_path;
    static RemindTimer remindTimer;
    public List<Snacks> cart = new ArrayList<>();

    public Customer(String data_path) {
        this.data_path = data_path;
    }

    public static void countDown() {
        RemindTimer remindTimer = new RemindTimer(120);
        // RemindTimer remindTimer = new RemindTimer(5);
    }




    public boolean checkUsernameExists() {
        boolean isExistingUser = false;
        try {
            Scanner sc = new Scanner(new File(data_path));
            while (sc.hasNextLine()) {
                String[] temp = sc.nextLine().split(",");
                if (temp[0].equals(this.username)) {
                    isExistingUser = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isExistingUser;
    }

    public boolean checkValidLogin() {
        boolean isValidLogin = false;
        try {
            Scanner sc = new Scanner(new File(data_path));
            while (sc.hasNextLine()) {
                String[] temp = sc.nextLine().split(",");
                String str = String.valueOf(this.passwordArray);
                if (temp[0].equals(this.username) && temp[1].equals(str)) {
                    isValidLogin = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isValidLogin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.passwordArray = password;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return passwordArray;
    }

    public int getPasswordLength() {
        return passwordArray.length;
    }

    public void addToCSV() {
        File file = new File(data_path);
        try {
            FileWriter fw = new FileWriter(file, true);
            String str = String.valueOf(this.passwordArray);
            fw.write(this.username + "," + str + "\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<String> usernamesList() throws IOException {
        List<String> usernames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(data_path))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                usernames.add(values[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usernames;
    }

}
