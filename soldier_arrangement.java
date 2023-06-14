/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingdom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author User
 */
public class soldier_arrangement extends WuKingdomHierarchy{
    
    public soldier_arrangement(){  

    }
    public  void sortGenerals(String attribute){
            Arrays.sort(generals, new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                   switch (attribute) {
                    case "Leadership":
                        return Integer.compare(o2.getLeadership(), o1.getLeadership());
                    case "Strength":
                        return Integer.compare(o2.getStrength(), o1.getStrength());
                    case "Intelligence":
                        return Integer.compare(o2.getIntel(), o1.getIntel());
                    case "Politic":
                        return Integer.compare(o2.getPolitic(), o1.getPolitic());
                    case "Hit point":
                        return Integer.compare(o2.getHitpoint(), o1.getHitpoint());
                    default:
                        return 0;
                } 
                }
            });
        }
        
    public void display(String attribute){
            switch (attribute){
                case "Strength": 
                    System.out.println("*****************sorted by strength*****************");
                    for (TreeNode general : generals) {
                    System.out.println(general.getName() + ": " + general.getStrength());
                    
        }
                    break;
                    case "Leadership": 
                    System.out.println("*****************sorted by Leadership*****************");
                    for (TreeNode general : generals) {
                    System.out.println(general.getName() + ": " + general.getLeadership());    
                    
        }
                    break;
                    case "Intelligence": 
                    System.out.println("*****************sorted by Intelligence*****************");
                    for (TreeNode general : generals) {
                    System.out.println(general.getName() + ": " + general.getIntel());
                   
    }
                    break;
                    case "Politic": 
                    System.out.println("*****************sorted by Politic*****************");
                    for (TreeNode general : generals) {
                    System.out.println(general.getName() + ": " + general.getPolitic());
                    
    }
                    break;
                    case "Hit point": 
                    System.out.println("*****************sorted by Hit point*****************");
                    for (TreeNode general : generals) {
                    System.out.println(general.getName() + ": " + general.getHitpoint());
                   
            }
                    break;
        }
        }
    
    public TreeNode binarySearchGeneral(String attribute, int target) {
        System.out.println("*****************searching for General with "+attribute +" " +target +" ability*****************");
        int low = 0;
        int high = generals.length-1;
        
        while(low<=high){
            int middle = low + (high-low)/2;
            int value;
            
            switch(attribute){
                case "LeaderShip":
                    value = generals[middle].getLeadership();
                    break;
                    case "Strength":
                    value = generals[middle].getStrength();
                    break;
                case "Intelligence":
                    value = generals[middle].getIntel();
                    break;
                case "Politic":
                    value = generals[middle].getPolitic();
                    break;
                case "Hit point":
                    value = generals[middle].getHitpoint();
                    break;
                
                default:
                    value =0;
                    break;
            }
            if(value==target){
               return generals[middle]; 
            }
            else if(value<target){
                high = middle-1;
            }
            else{
                low = middle +1;
            }   
        }
        return null;
}
    
    public List<TreeNode> suggestGeneralsByAbility(String attribute, String level) {
        List<List<TreeNode>> combinations = generateCombinations();
        List<TreeNode> suggestedGenerals = new ArrayList<>();

        for (List<TreeNode> combination : combinations) {
            int sum = calculateSum(combination, attribute);
            boolean meetsRequirement;
            

            switch (level) {
                case "S":
                    meetsRequirement = sum >= 250;
                    break;
                case "A":
                    meetsRequirement = sum >= 220;
                    break;
                case "B":
                    meetsRequirement = sum >= 190;
                    break;
                case "C":
                    meetsRequirement = sum <= 190;
                    break;
                default:
                    meetsRequirement = false;
                    break;
            }

            if (meetsRequirement) {
                suggestedGenerals.addAll(combination);
            }
        }

        return suggestedGenerals;
    }

    private List<List<TreeNode>> generateCombinations() {
        List<List<TreeNode>> combinations = new ArrayList<>();
        int n = generals.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    List<TreeNode> combination = new ArrayList<>();
                    combination.add(generals[i]);
                    combination.add(generals[j]);
                    combination.add(generals[k]);
                    combinations.add(combination);
                }
            }
        }

        return combinations;
    }

    private int calculateSum(List<TreeNode> generals, String attribute) {
        int sum = 0;

        for (TreeNode general : generals) {
            switch (attribute) {
                case "Leadership":
                    sum += general.getLeadership();
                    break;
                case "Strength":
                    sum += general.getStrength();
                    break;
                case "Intelligence":
                    sum += general.getIntel();
                    break;
                case "Politic":
                    sum += general.getPolitic();
                    break;
            }
        }

        return sum;
    }
}
