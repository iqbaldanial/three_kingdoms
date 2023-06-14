/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kingdom;

/**
 *
 * @author User
 */

import java.util.*;
public class newmain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        
        do {
            System.out.println("\n+--------------------SLUM Controller---------------------+");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("| 1 | Wu kingdom's hierarchy and soldier's arrangment    |");
            System.out.println("| 2 | Borrowing Arrows with straw boats                  |");   
            System.out.println("| 3 | Path for attacking simulation                      |");
            System.out.println("| 4 | Food harvesting                                    |");
            System.out.println("| 5 | Encrypted text for letter                          |");
            System.out.println("| 6 |                                      |");
            System.out.println("| 7 |                                 |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("-1 : Quit");
            System.out.print("Select -> ");
            int select = sc.nextInt();
            System.out.println();
            
            switch (select) {
                case 1 -> one();
                case 2 -> two();
                case 3 -> three();
                case 4 -> four();
                case 5 -> five();
                
                case -1 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid selection");
            }
        } while (true);
    }
    public static void one(){
        soldier_arrangement b = new soldier_arrangement();
        
         b.sortGenerals("Strength");
       b.display("Strength");
       b.sortGenerals("Leadership");
       b.display("Leadership");
       b.sortGenerals("Politic");
       b.display("Politic");
       b.sortGenerals("Intelligence");
       b.display("Intelligence");
       b.sortGenerals("Hit point");
       b.display("Hit point");
       TreeNode searchedGeneral = b.binarySearchGeneral("Hit point", 88 );
        if (searchedGeneral != null) {
            System.out.println("General found: " + searchedGeneral.getName());
        } else {
            System.out.println("General not found.");
        }
        System.out.println();
        List<TreeNode> suggestedGenerals = b.suggestGeneralsByAbility("Politic", "S");
        System.out.println("Suggested Generals for Politic (S Level):");
        for (TreeNode general : suggestedGenerals) {
            System.out.println(general.getName() + ": " + general.getPolitic());   
        }
        
        System.out.println();
        List<TreeNode> suggestedGenerals2 = b.suggestGeneralsByAbility("Leadership", "S");
        System.out.println("Suggested Generals for Leadership (S Level):");
        for (TreeNode general : suggestedGenerals2) {
            System.out.println(general.getName() + ": " + general.getLeadership());   
        }
        
        System.out.println();
        List<TreeNode> suggestedGenerals3 = b.suggestGeneralsByAbility("Strength", "S");
        System.out.println("Suggested Generals for Strength (S Level):");
        for (TreeNode general : suggestedGenerals3) {
            System.out.println(general.getName() + ": " + general.getStrength());   
        }
        
        System.out.println();
        List<TreeNode> suggestedGenerals4 = b.suggestGeneralsByAbility("Intelligence", "S");
        System.out.println("Suggested Generals for Intelligence (S Level):");
        for (TreeNode general : suggestedGenerals4) {
            System.out.println(general.getName() + ": " + general.getIntel());
    }
  }
    
    public static void two(){
        arrows_with_straw_boats s = new arrows_with_straw_boats();
    }
    public static void three(){
        GraphT a = new GraphT();
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> storePath = a.storePath;
        
        int startingNode=1;
        int endingNode;
        //int endingNode=8;
        
        System.out.print("Enter the base camp for enemy base camp : ");
        endingNode=sc.nextInt();
        
        a.dfs(startingNode-1,endingNode-1, "");
        a.minimumPath(storePath);
    }
    public static void four(){}
    public static void five(){
        Scanner sc = new Scanner(System.in);
        Scanner sh = new Scanner(System.in);
        EncryptedTextConverter cipher = new EncryptedTextConverter();
        String input;
        int shift, num;
        
          
        System.out.println("Choose:\n0 : encryption\n1 : decryption");
        int choice = sc.nextInt();
        switch(choice){
            case 0 -> {
                System.out.println("Enter a string for encryption using Caesar Cipher: "); 
                input = sh.nextLine();
                System.out.println("Enter the value by which each character in the plaintext message gets shifted: "); 
                shift = sc.nextInt();
                System.out.println("Enter the value by which each character in the plaintext message gets added: "); 
                num = sc.nextInt();
                System.out.println("Encrypted Data ===> "+cipher.encryption(input, shift, num));
            }

            case 1 -> {
                System.out.println("Enter a string for decryption using Caesar Cipher: "); 
                input = sh.nextLine();
                System.out.println("Enter the value by which each character in the plaintext message gets shifted: "); 
                shift = sc.nextInt();
                System.out.println("Enter the value by which each character in the plaintext message gets added: "); 
                num = sc.nextInt();
                System.out.println("Decrypted Data ===> "+cipher.decryption(input, shift, num));
            }
        }
    }
}


