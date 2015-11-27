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
import java.util.ArrayList;

/**
 *
 * @author Justinson
 */
class Snek extends Environment implements CellDataProviderIntf, MoveValidatorIntf {

    private Grid grid;
    private Presidential bob;
    private ArrayList<Barrier> barriers;

    public Snek() {

        grid = new Grid(25, 25, 20, 20, new Point(10, 50), Color.BLACK);
        bob = new Presidential(Direction.LEFT, grid, this);
       
        barriers = new ArrayList<>();
        barriers.add(new Barrier(0, 0, Color.GREEN, this));
        
        barriers.add(new Barrier(1, 0, Color.GREEN, this));
        barriers.add(new Barrier(2, 0, Color.GREEN, this));
        barriers.add(new Barrier(3, 0, Color.GREEN, this));
        barriers.add(new Barrier(0, 1, Color.GREEN, this));
        barriers.add(new Barrier(0, 2, Color.GREEN, this));
        barriers.add(new Barrier(0, 3, Color.GREEN, this));
    }

    @Override
    public void initializeEnvironment() {
    }

    int moveDelay = 0;
    int moveDelayLimit = 3;

    @Override
    public void timerTaskHandler() {
//        System.out.println("Hey" + ++counter);

        if (bob != null) {
            if (moveDelay >= moveDelayLimit) {
                bob.move();
                moveDelay = 0;

            } else {
                moveDelay++;
            }

        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            bob.setDirection(Direction.LEFT);
            bob.move();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            bob.setDirection(Direction.RIGHT);
            bob.move();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            bob.setDirection(Direction.UP);
            bob.move();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bob.setDirection(Direction.DOWN);
            bob.move();
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

        if (bob != null) {
            bob.draw(graphics);
        }
        
        if (barriers != null) {
            for (int i = 0; i < barriers.size(); i++) {
               barriers.get(i).draw(graphics);
            }
 
//            barriers.draw(graphics);
        }
        
    }

//<editor-fold defaultstate="collapsed" desc="CellDataProviderIntf">
    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;
    }

    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MoveValidatorIntf">
    @Override
    public Point validateMove(Point proposedLocation) {
    //if the x value of the head location is less than 0
        if (proposedLocation.x < 0) {
            System.out.println("You dead");
          
            }
        return proposedLocation;
            
    }
}
        
        
        

    
//</editor-fold>

