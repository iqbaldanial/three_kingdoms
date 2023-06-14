/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingdom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TreeNode {
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
