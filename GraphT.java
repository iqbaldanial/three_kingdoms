/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingdom;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class GraphT {
        ArrayList<String> storePath = new ArrayList<>();

    public int[][] edges = {

        { 0, 1, 1, 0, 0, 1, 0, 0, 0, 1 },
        { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
        { 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
        { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 1, 0, 1, 1, 0, 0, 0 },
        { 1, 0, 0, 0, 1, 0, 1, 1, 0, 0 },
        { 0, 0, 0, 0, 1, 1, 0, 1, 1, 0 },
        { 0, 0, 0, 0, 0, 1, 1, 0, 1, 1 },
        { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1 },
        { 1, 0, 0, 0, 0, 0, 0, 1, 1, 0 },
    };
    
    

public void dfs(int start, int end, String str) {

        str+=" "+(start+1);


            if (start == end) {
                storePath.add(str);

                return;
             }



        for (int i = 0; i < edges.length; i++) {

                if(edges[start][i]==1 && !str.contains(""+(i+1))){
                    dfs(i, end, str);
                }
            }


    }
    
    public void minimumPath(ArrayList<String> storePath){
        //obtain min length
        int indexLength = storePath.get(0).split(" ").length;
        for(int k =1;k<storePath.size();k++){
            if(storePath.get(k).split(" ").length<=indexLength){
                indexLength = storePath.get(k).split(" ").length;
            }
        }
        
        
        System.out.println("The Path");
        for(int l=0;l<storePath.size();l++){
            if(storePath.get(l).split(" ").length==indexLength){
                System.out.println(storePath.get(l));
            }
        }
    }    

}
