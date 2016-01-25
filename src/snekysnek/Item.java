/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snekysnek;

import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Justinson
 */
public class Item {
    private final int y;
    private final int x;
    private final String type;
    private final MoveValidatorIntf moveValidator;
    public void draw(Graphics graphics, Object image){
        if(image != null){
            
        }
    }

     public Item(int x, int y, String type, Image image, CellDataProviderIntf celldata,MoveValidatorIntf moveValidator ){
         this.x = x;
         this.y = y;
         this.type = type;        
         this.moveValidator = moveValidator;
     }

//     public static final String ITEM_TYPE_VOTES = "VOTES";
//        image = ResourceTools.loadImageFromResource("votes.png");
// 
//            
//    
//     private int x, y;
//     private boolean alive;
//     private String type;
//     
}
  


