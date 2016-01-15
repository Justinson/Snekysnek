/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snekysnek;

import audio.AudioPlayer;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import images.ResourceTools;
import java.awt.Color;
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

        this.setBackground(ResourceTools.loadImageFromResource("snekysnek/goodbless.jpg"));

        grid = new Grid(35, 25, 20, 20, new Point(10, 50), Color.BLACK);
        bob = new Presidential(Direction.LEFT, grid, this);

        barriers = new ArrayList<>();
        barriers.add(new Barrier(0, 0, Color.BLUE, this));

//        items = new Arraylist<>();
//        items.add(new Item(10, 5, "POWER_UP"))
//                ResourceTools.loadImageFromResource("snekysnek/Trumpalive.png"),
//                this));
//<editor-fold defaultstate="collapsed" desc="Barriers">
        createBarrierRange(0, 0, 0, grid.getRows() - 1, Color.WHITE);
        createBarrierRange(grid.getColumns() - 1, 0, grid.getColumns() - 1, grid.getRows() - 1, Color.WHITE);
        createBarrierRange(0, 0, grid.getColumns() - 1, 0, Color.WHITE);
        createBarrierRange(0, grid.getRows() - 1, grid.getColumns() - 1, grid.getRows() - 1, Color.WHITE);

//</editor-fold>
        //
    }

    private void createBarrierRange(int startX, int startY, int endX, int endY, Color color) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                barriers.add(new Barrier(x, y, color, this));
            }
        }
    }

    @Override
    public void initializeEnvironment() {
    }

    int moveDelay = 0;
    int moveDelayLimit = 1;

    @Override
    public void timerTaskHandler() {
//        System.out.println("Hey" + ++counter);`

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

//        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//            AudioPlayer.play("/snekysnek/Pickaxe.wav");
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

//            if (items != null) {
//                for (int i = 0; i < items.size(); i++) {
//                    items.get(i).draw(graphics);
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

