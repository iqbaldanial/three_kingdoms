/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingdom;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author User
 */
public class WuKingdomHierarchy {
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
                
               
        System.out.println(sunQuan.getName());
        System.out.println();
        // Perform breadth-first search traversal to display the tree data
        System.out.println("Military-->");
        System.out.println("Leader: "+zhouYu.getName());
        printChildren(zhouYu);
        //breadthFirstSearch(zhouYu);
        System.out.println();
        System.out.println("Management-->");
        System.out.println("Leader: "+zhangZhao.getName());
        printChildren(zhangZhao);
        //breadthFirstSearch(zhangZhao);
        //breadthFirstSearch(sunQuan);
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
    
    private static void printChildren(TreeNode node) {
    List<TreeNode> children = node.getChildren();
    for (TreeNode child : children) {
        System.out.println("  - " + child.getName());
        printChildren(child); // Recursive call to print children of the child node
    }
}

}
