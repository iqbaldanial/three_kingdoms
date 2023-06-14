/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingdom;

/**
 *
 * @author User
 */
import java.util.*;
public class arrows_with_straw_boats {
        protected int front, left, right, back, N,none=0;
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
        System.out.println();

        N = 9;
        System.out.println("Arrow :");
        for (int i = 0; i < N; i++) {
            int temp = cha.nextInt();
            arrow.add(temp);
        }
        System.out.println("Arrow: " + arrow.toString());
        System.out.println();
        List<String> boatDirections = determineBestDirections(front, left, right, back, arrow, efficiencies);
        System.out.println("Boat direction: " + boatDirections);
        List<Integer> arrowReceived = calculateArrowReceived(front, left, right, back,none, arrow, boatDirections,efficiencies);
        System.out.println("Arrow received: " + arrowReceived);
        int totalArrows = calculateTotalArrows(arrowReceived);
        System.out.println("Total = " + totalArrows);
        
    }

    public List<String> determineBestDirections(int front, int left, int right, int back, ArrayList<Integer> arrow,double[] efficiencies) {
        List<String> boatDirections = new ArrayList<>();
        int frontUses=0,rightUses=0,leftUses=0,backUses=0;
        int[] remainingStrawmen = {front, left, right, back,none};
        for (int arrows : arrow) { 
            String direction = getBestDirection(remainingStrawmen,frontUses,rightUses,leftUses,backUses);
            boatDirections.add(direction);
            int directionIndex = getDirectionIndex(direction);
            switch(directionIndex){
            case 0:
                  remainingStrawmen[directionIndex]= (int)(efficiencies[frontUses]*front);
                  
                  frontUses++;
                 break; 
            case 1:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[leftUses]*left);

                 leftUses++;
                 break;
            case 2:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[rightUses]*right);

                 rightUses++;
                 break;
            case 3:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[backUses]*back);
                 
                 backUses++;
                 break;         
           }
        }
        return boatDirections;
    }
    
    public String getBestDirection(int[] remainingStrawmen,int frontUses,int rightUses,int leftUses,int backUses) {
        int maxStrawmen = -1;
        String bestDirection = "";
        
        if(frontUses == 2 && leftUses == 2 && rightUses == 2 && backUses == 2) {
                bestDirection = "none";
            }
        if (remainingStrawmen[0] > maxStrawmen && frontUses < 2) {
            maxStrawmen = remainingStrawmen[0];
            bestDirection = "front";
        }
        if (remainingStrawmen[1] > maxStrawmen && leftUses < 2) {
            maxStrawmen = remainingStrawmen[1];
            bestDirection = "left";
        }
        if (remainingStrawmen[2] > maxStrawmen && rightUses < 2) {
            maxStrawmen = remainingStrawmen[2];
            bestDirection = "right";
        }
        if (remainingStrawmen[3] > maxStrawmen && backUses < 2) {
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
            case"none":
                return 4;
            default:
                return -1;
        }
    }
    
    public List<Integer> calculateArrowReceived(int front, int left, int right, int back, int none, ArrayList<Integer> arrow, List<String> boatDirections,double[] efficiencies){
        int frontUses=0,rightUses=0,leftUses=0,backUses=0;
        List<Integer> arrowReceived = new ArrayList<>();
        int[] remainingStrawmen = {front, left, right, back,none};        
        for (int i = 0; i < arrow.size(); i++) {
            int arrows = arrow.get(i); //2000
            String direction = boatDirections.get(i); //left
            int directionIndex = getDirectionIndex(direction); //1
            double efficiency = (double) remainingStrawmen[directionIndex] / 100.0;
            int arrowsReceived = (int) (arrows * efficiency);
            if(frontUses == 2 && leftUses == 2 && rightUses == 2 && backUses == 2) {
                arrowReceived.add(0);
                break;
            }
            arrowReceived.add(arrowsReceived);
            switch(directionIndex){
            case 0:
                  remainingStrawmen[directionIndex]= (int)(efficiencies[frontUses]*front);
                  
                  frontUses++;
                 break; 
            case 1:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[leftUses]*left);

                 leftUses++;
                 break;
            case 2:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[rightUses]*right);

                 rightUses++;
                 break;
            case 3:
                 remainingStrawmen[directionIndex]= (int)(efficiencies[backUses]*back);
                 
                 backUses++;
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
