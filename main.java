/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.assigment_ds;
import java.util.*;
/**
 *
 * @author User
 */

class TreeNode {
    private String name;
    private int Strength, Leadership, Intelligence,  Politic, Hitpoint;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(String name,int Strength, int Leadership, int Intelligence, int Politic, int Hitpoint) {
        this.name = name;
        this.Hitpoint=Hitpoint;
        this.Intelligence=Intelligence;
        this.Leadership=Leadership;
        this.Politic=Politic;
        this.Strength=Strength;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode childNode) {
        childNode.parent = this;
        children.add(childNode);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public TreeNode getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
    public int getIntel(){
        return Intelligence;
    }
    public int getStrength(){
        return Strength;
    }
    public int getLeadership(){
        return Leadership;
    }
    public int getPolitic(){
        return Politic;
    }
    public int getHitpoint(){
        return Hitpoint;
    }

}
class WuKingdomHierarchy {
    protected TreeNode[] generals;
    public  WuKingdomHierarchy (){
        generals = new TreeNode[10];
        initializeGenerals();
    }
    private void initializeGenerals() {
        // Create the Emperor Sun Quan
        TreeNode sunQuan = new TreeNode("Sun Quan", 96, 98, 72, 77, 95);

        // Create the Chiefs of Military and Management
        TreeNode zhouYu = new TreeNode("Zhou Yu", 80, 86, 97, 80, 90);
        TreeNode zhangZhao = new TreeNode("Zhang Zhao", 22, 80, 89, 99, 60);

        // Assign Chiefs to the Emperor
        sunQuan.addChild(zhouYu);
        sunQuan.addChild(zhangZhao);
        generals[0] = new TreeNode("Xu Sheng", 90, 78, 72, 40, 94);
        generals[1] = new TreeNode("Zhu Ge Jin", 63, 61, 88, 82, 71);
        generals[2] = new TreeNode("Lu Su", 43, 87, 84, 88, 53);
        generals[3] = new TreeNode("Tai Shi Ci", 96, 81, 43, 33, 97);
        generals[4] = new TreeNode("Xiao Qiao", 42, 52, 89, 77, 34);
        generals[5] = new TreeNode("Da Qiao", 39, 62, 90, 62, 41);
        generals[6] = new TreeNode("Zhou Tai", 92, 89, 72, 43, 99);
        generals[7] = new TreeNode("Gan Ning", 98, 92, 45, 23, 97);
        generals[8] = new TreeNode("Lu Meng", 70, 77, 93, 83, 88);
        generals[9] = new TreeNode("Huang Gai", 83, 98, 72, 42, 89);
                for (int i = 0; i < generals.length; i++) {
            if (generals[i].getIntel() > generals[i].getStrength()) {
                zhangZhao.addChild(generals[i]);
            } else {
                zhouYu.addChild(generals[i]);
            }
        }

        // Perform breadth-first search traversal to display the tree data
        breadthFirstSearch(sunQuan);
    }
    public static void breadthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.getName());
            
            List<TreeNode> children = current.getChildren();
            for (TreeNode child : children) {
                queue.offer(child);
            }
        }
    }

}
    class soldier_arangement extends WuKingdomHierarchy{
        
        public soldier_arangement(){  

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
class arrows_with_straw_boats {
    protected int front, left, right, back, N;
    protected ArrayList<Integer> arrow;
    public arrows_with_straw_boats() {
        
        double[] efficiencies={0.8,0.4,0.0};
        arrow = new ArrayList<>();
        System.out.println("Number of straw men");
        Scanner cha = new Scanner(System.in);

        System.out.print("Front: ");
        front = cha.nextInt();

        System.out.print("Left: ");
        left = cha.nextInt();

        System.out.print("Right: ");
        right = cha.nextInt();

        System.out.print("Back: ");
        back = cha.nextInt();

        N = 8;
        System.out.println("Arrow :");
        for (int i = 0; i < N; i++) {
            int temp = cha.nextInt();
            arrow.add(temp);
        }
        System.out.println("Arrow: " + arrow.toString());
        List<String> boatDirections = determineBestDirections(front, left, right, back, arrow, efficiencies);
        System.out.println("Boat direction: " + boatDirections);
        List<Integer> arrowReceived = calculateArrowReceived(front, left, right, back, arrow, boatDirections,efficiencies);
        System.out.println("Arrow received: " + arrowReceived);
        int totalArrows = calculateTotalArrows(arrowReceived);
        System.out.println("Total = " + totalArrows);
        
    }

public List<String> determineBestDirections(int front, int left, int right, int back, ArrayList<Integer> arrow,double[] efficiencies) {
        List<String> boatDirections = new ArrayList<>();
        int h=0,j=0,k=0,y=0,z=0;
        int[] remainingStrawmen = new int[]{front, left, right, back};
        for (int arrows : arrow) { 
            String direction = getBestDirection(remainingStrawmen);
            boatDirections.add(direction);
            int directionIndex = getDirectionIndex(direction);
            switch(directionIndex){
            case 0:
                  remainingStrawmen[directionIndex]= (int)(efficiencies[h]*front);
                  
                  h++;
                 break; 
            case 1:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[j]*left);

                 j++;
                 break;
            case 2:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[k]*right);

                 k++;
                 break;
            case 3:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[y]*back);
                 
                 y++;
                 break;         
           }
        }
        return boatDirections;
    }
    public String getBestDirection(int[] remainingStrawmen) {
        int maxStrawmen = -1;
        String bestDirection = "";

        if (remainingStrawmen[0] > maxStrawmen) {
            maxStrawmen = remainingStrawmen[0];
            bestDirection = "front";
        }
        if (remainingStrawmen[1] > maxStrawmen) {
            maxStrawmen = remainingStrawmen[1];
            bestDirection = "left";
        }
        if (remainingStrawmen[2] > maxStrawmen) {
            maxStrawmen = remainingStrawmen[2];
            bestDirection = "right";
        }
        if (remainingStrawmen[3] > maxStrawmen) {
            bestDirection = "back";
        }

        return bestDirection;
    }
    public int getDirectionIndex(String direction) {
        switch (direction) {
            case "front":
                return 0;
            case "left":
                return 1;
            case "right":
                return 2;
            case "back":
                return 3;
            default:
                return -1;
        }
    }
    public List<Integer> calculateArrowReceived(int front, int left, int right, int back, ArrayList<Integer> arrow, List<String> boatDirections,double[] efficiencies){
        int h=0,j=0,k=0,y=0;
        List<Integer> arrowReceived = new ArrayList<>();
        int[] remainingStrawmen = new int[]{front, left, right, back};        
        for (int i = 0; i < arrow.size(); i++) {
            int arrows = arrow.get(i); //2000
            String direction = boatDirections.get(i); //left
            int directionIndex = getDirectionIndex(direction); //1
            double efficiency = (double) remainingStrawmen[directionIndex] / 100.0;
            int arrowsReceived = (int) (arrows * efficiency);
            arrowReceived.add(arrowsReceived);
            switch(directionIndex){
            case 0:
                  remainingStrawmen[directionIndex]= (int)(efficiencies[h]*front);
                  
                  h++;
                 break; 
            case 1:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[j]*left);

                 j++;
                 break;
            case 2:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[k]*right);

                 k++;
                 break;
            case 3:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[y]*back);
                 
                 y++;
                 break;         
           }
        }
        return arrowReceived;
    }
    public static int calculateTotalArrows(List<Integer> arrowReceived){
        int total=0;
        for(int arrow : arrowReceived){
            total+=arrow;
        }
        return total;
    }
      
}
public class main {
    public static void main(String[] args) {
       // WuKingdomHierarchy a = new WuKingdomHierarchy();
       soldier_arangement b = new soldier_arangement();
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
        List<TreeNode> suggestedGenerals = b.suggestGeneralsByAbility("Politic", "A");
        System.out.println("Suggested Generals for Politic (A Level):");
        for (TreeNode general : suggestedGenerals) {
            System.out.println(general.getName() + ": " + general.getPolitic());   
        }
        
        //ArrowsWithStrawBoats s = new ArrowsWithStrawBoats();
        arrows_with_straw_boats s = new arrows_with_straw_boats();
        
        EncryptedTextConverter.main(args);

    }
    }

