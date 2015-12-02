/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snekysnek;

import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Justinson
 */
class Snek extends Environment implements CellDataProviderIntf, MoveValidatorIntf {
    
    Image image;
    int x;
    int y;
    private Grid grid;
    private Presidential bob;
    private ArrayList<Barrier> barriers;

    public Snek() {

        grid = new Grid(25, 25, 20, 20, new Point(10, 50), Color.BLACK);
        bob = new Presidential(Direction.LEFT, grid, this);

        barriers = new ArrayList<>();
        barriers.add(new Barrier(0, 0, Color.BLUE, this));

        barriers.add(new Barrier(1, 0, Color.BLUE, this));
        barriers.add(new Barrier(2, 0, Color.BLUE, this));
        barriers.add(new Barrier(3, 0, Color.BLUE, this));
        barriers.add(new Barrier(4, 0, Color.BLUE, this));
        barriers.add(new Barrier(5, 0, Color.BLUE, this));
        barriers.add(new Barrier(6, 0, Color.BLUE, this));
        barriers.add(new Barrier(7, 0, Color.BLUE, this));
        barriers.add(new Barrier(8, 0, Color.BLUE, this));
        barriers.add(new Barrier(9, 0, Color.BLUE, this));
        barriers.add(new Barrier(10, 0, Color.BLUE, this));
        barriers.add(new Barrier(11, 0, Color.BLUE, this));
        barriers.add(new Barrier(12, 0, Color.BLUE, this));
        barriers.add(new Barrier(13, 0, Color.BLUE, this));
        barriers.add(new Barrier(14, 0, Color.BLUE, this));
        barriers.add(new Barrier(15, 0, Color.BLUE, this));
        barriers.add(new Barrier(16, 0, Color.BLUE, this));
        barriers.add(new Barrier(17, 0, Color.BLUE, this));
        barriers.add(new Barrier(18, 0, Color.BLUE, this));
        barriers.add(new Barrier(19, 0, Color.BLUE, this));
        barriers.add(new Barrier(20, 0, Color.BLUE, this));
        barriers.add(new Barrier(21, 0, Color.BLUE, this));
        barriers.add(new Barrier(22, 0, Color.BLUE, this));
        barriers.add(new Barrier(23, 0, Color.BLUE, this));
        barriers.add(new Barrier(24, 0, Color.BLUE, this));

        barriers.add(new Barrier(0, 1, Color.WHITE, this));
        barriers.add(new Barrier(0, 2, Color.WHITE, this));
        barriers.add(new Barrier(0, 3, Color.WHITE, this));
        barriers.add(new Barrier(0, 3, Color.WHITE, this));
        barriers.add(new Barrier(0, 3, Color.WHITE, this));
        barriers.add(new Barrier(0, 3, Color.WHITE, this));
        barriers.add(new Barrier(0, 4, Color.WHITE, this));
        barriers.add(new Barrier(0, 5, Color.WHITE, this));
        barriers.add(new Barrier(0, 6, Color.WHITE, this));
        barriers.add(new Barrier(0, 7, Color.WHITE, this));
        barriers.add(new Barrier(0, 8, Color.WHITE, this));
        barriers.add(new Barrier(0, 9, Color.WHITE, this));
        barriers.add(new Barrier(0, 10, Color.WHITE, this));
        barriers.add(new Barrier(0, 11, Color.WHITE, this));
        barriers.add(new Barrier(0, 12, Color.WHITE, this));
        barriers.add(new Barrier(0, 13, Color.WHITE, this));
        barriers.add(new Barrier(0, 14, Color.WHITE, this));
        barriers.add(new Barrier(0, 15, Color.WHITE, this));
        barriers.add(new Barrier(0, 16, Color.WHITE, this));
        barriers.add(new Barrier(0, 17, Color.WHITE, this));
        barriers.add(new Barrier(0, 18, Color.WHITE, this));
        barriers.add(new Barrier(0, 19, Color.WHITE, this));
        barriers.add(new Barrier(0, 20, Color.WHITE, this));
        barriers.add(new Barrier(0, 21, Color.WHITE, this));
        barriers.add(new Barrier(0, 22, Color.WHITE, this));
        barriers.add(new Barrier(0, 23, Color.WHITE, this));
        barriers.add(new Barrier(0, 24, Color.WHITE, this));

        barriers.add(new Barrier(24, 0, Color.BLUE, this));
        barriers.add(new Barrier(24, 1, Color.BLUE, this));
        barriers.add(new Barrier(24, 2, Color.BLUE, this));
        barriers.add(new Barrier(24, 3, Color.BLUE, this));
        barriers.add(new Barrier(24, 4, Color.BLUE, this));
        barriers.add(new Barrier(24, 5, Color.BLUE, this));
        barriers.add(new Barrier(24, 6, Color.BLUE, this));
        barriers.add(new Barrier(24, 7, Color.BLUE, this));
        barriers.add(new Barrier(24, 8, Color.BLUE, this));
        barriers.add(new Barrier(24, 9, Color.BLUE, this));
        barriers.add(new Barrier(24, 10, Color.BLUE, this));
        barriers.add(new Barrier(24, 11, Color.BLUE, this));
        barriers.add(new Barrier(24, 12, Color.BLUE, this));
        barriers.add(new Barrier(24, 13, Color.BLUE, this));
        barriers.add(new Barrier(24, 14, Color.BLUE, this));
        barriers.add(new Barrier(24, 15, Color.BLUE, this));
        barriers.add(new Barrier(24, 16, Color.BLUE, this));
        barriers.add(new Barrier(24, 17, Color.BLUE, this));
        barriers.add(new Barrier(24, 18, Color.BLUE, this));
        barriers.add(new Barrier(24, 19, Color.BLUE, this));
        barriers.add(new Barrier(24, 20, Color.BLUE, this));
        barriers.add(new Barrier(24, 21, Color.BLUE, this));
        barriers.add(new Barrier(24, 22, Color.BLUE, this));
        barriers.add(new Barrier(24, 23, Color.BLUE, this));
        barriers.add(new Barrier(24, 24, Color.GREEN, this));

       
        barriers.add(new Barrier(24, 1, Color.RED, this));
        barriers.add(new Barrier(24, 2, Color.RED, this));
        barriers.add(new Barrier(24, 3, Color.RED, this));
        barriers.add(new Barrier(24, 4, Color.RED, this));
        barriers.add(new Barrier(24, 5, Color.RED, this));
        barriers.add(new Barrier(24, 6, Color.RED, this));
        barriers.add(new Barrier(24, 7, Color.RED, this));
        barriers.add(new Barrier(24, 8, Color.RED, this));
        barriers.add(new Barrier(24, 9, Color.RED, this));
        barriers.add(new Barrier(24, 10, Color.RED, this));
        barriers.add(new Barrier(24, 11, Color.RED, this));
        barriers.add(new Barrier(24, 12, Color.RED, this));
        barriers.add(new Barrier(24, 13, Color.RED, this));
        barriers.add(new Barrier(24, 14, Color.RED, this));
        barriers.add(new Barrier(24, 15, Color.RED, this));
        barriers.add(new Barrier(24, 16, Color.RED, this));
        barriers.add(new Barrier(24, 17, Color.RED, this));
        barriers.add(new Barrier(24, 18, Color.RED, this));
        barriers.add(new Barrier(24, 19, Color.RED, this));
        barriers.add(new Barrier(24, 20, Color.RED, this));
        barriers.add(new Barrier(24, 21, Color.RED, this));
        barriers.add(new Barrier(24, 22, Color.RED, this));
        barriers.add(new Barrier(24, 23, Color.RED, this));
        barriers.add(new Barrier(24, 24, Color.BLUE, this));

        barriers.add(new Barrier(0, 24, Color.BLUE, this));
        barriers.add(new Barrier(1, 24, Color.BLUE, this));
        barriers.add(new Barrier(2, 24, Color.BLUE, this));
        barriers.add(new Barrier(3, 24, Color.BLUE, this));
        barriers.add(new Barrier(4, 24, Color.BLUE, this));
        barriers.add(new Barrier(5, 24, Color.BLUE, this));
        barriers.add(new Barrier(6, 24, Color.BLUE, this));
        barriers.add(new Barrier(7, 24, Color.BLUE, this));
        barriers.add(new Barrier(8, 24, Color.BLUE, this));
        barriers.add(new Barrier(9, 24, Color.BLUE, this));
        barriers.add(new Barrier(10, 24, Color.BLUE, this));
        barriers.add(new Barrier(11, 24, Color.BLUE, this));
        barriers.add(new Barrier(12, 24, Color.BLUE, this));
        barriers.add(new Barrier(13, 24, Color.BLUE, this));
        barriers.add(new Barrier(14, 24, Color.BLUE, this));
        barriers.add(new Barrier(15, 24, Color.BLUE, this));
        barriers.add(new Barrier(16, 24, Color.BLUE, this));
        barriers.add(new Barrier(17, 24, Color.BLUE, this));
        barriers.add(new Barrier(18, 24, Color.BLUE, this));
        barriers.add(new Barrier(19, 24, Color.BLUE, this));
        barriers.add(new Barrier(20, 24, Color.BLUE, this));
        barriers.add(new Barrier(21, 24, Color.BLUE, this));
        barriers.add(new Barrier(22, 24, Color.BLUE, this));
        barriers.add(new Barrier(23, 24, Color.BLUE, this));
        barriers.add(new Barrier(24, 24, Color.BLUE, this));

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

