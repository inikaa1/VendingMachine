package cc09_group2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Owner {
    static Customer user = new Customer("app/CustomerInfo.csv");
    static String[] temp;

    
    //WORK
    public void setUserRole(String username, String role) {
        
        if(role.equals("seller")) {
            File file = new File("UserRole.csv");
            try {
                FileWriter fw = new FileWriter(file, true);
                fw.write(username + "," + role+"\n");
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (role.equals("cashier")) {
            File file = new File("UserRole.csv");
            try {
                FileWriter fw = new FileWriter(file, true);
                fw.write(username + "," + role+"\n");
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (role.equals("owner")) {
            File file = new File("UserRole.csv");
            try {
                FileWriter fw = new FileWriter(file, true);
                fw.write(username + "," + role+"\n");
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Role not defined");
        }
        

    }

    public static void getUserRole() {
        List<String> usernames = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("UserRole.csv"))) {
            String line = "";   
            while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    usernames.add(values[0]);
                    roles.add(values[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("USER REPORT:");
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %-20s | %-10s |%n", "Username", "Role");
        for(int j = 0; j < usernames.size(); j++) {
            System.out.printf("| %-20s | %-10s |%n", usernames.get(j), roles.get(j));
        }
        System.out.printf("------------------------------------------%n");
    }


    // public static void deleteUserRole(String filepath, String removeTerm){
    //     String tempFile = "temp.csv";
    //     File oldFile = new File(filepath);
    //     File newFile = new File(tempFile);
    //     String name = ""; String role = "";

    //     try{
    //         FileWriter fw = new FileWriter(tempFile,true);
    //         BufferedWriter bw = new BufferedWriter(fw);
    //         PrintWriter pw =new PrintWriter(bw);
    //         Scanner x= new Scanner(new File(filepath));
    //         x.useDelimiter("[,\n]");
    //         while(x.hasNext()){
    //             name = x.next();
    //             role = x.next();
    //             if(!name.equals(removeTerm)){
    //                 pw.print(name+","+role);
    //             }
    //         }
    //         x.close();
    //         pw.flush();
    //         pw.close();
    //         oldFile.delete();
    //         File dump = new File(filepath);
    //         newFile.renameTo(dump);
    //     }catch(Exception e){
    //         e.printStackTrace();
    //     }
    // }

   
}
