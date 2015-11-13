/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snekysnek;

import environment.Environment;
import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Justinson
 */
class Snek extends Environment {

    Grid grid;

    public Snek() {
        grid = new Grid(25, 25, 20, 20, new Point(10, 50), Color.yellow);
    }

    @Override
    public void initializeEnvironment() {
    }

    int counter;

    @Override
    public void timerTaskHandler() {
//        System.out.println("Hey" + ++counter);
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Go left");
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Go right");
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Go up");
        }
        
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Go down");
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
           if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("GO UP");
        }
              if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("GO LEFT");
        }
               if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("GO DOWN");
        }
           if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("GO RIGHT");
        }

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
        System.out.println("mouse click at " + e.getPoint());
        System.out.println("Mouse clicked in cell " + grid.getCellLocationFromSystemCoordinate(e.getPoint()));
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }
    }

}
