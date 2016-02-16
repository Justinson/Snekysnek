/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snekysnek;

import audio.AudioPlayer;
import audio.Playlist;
import audio.SoundManager;
import audio.Source;
import audio.Track;
import environment.Environment;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Justinson
 */
class Election extends Environment implements CellDataProviderIntf, MoveValidatorIntf {

    Image image;
    int x;
    int y;
    private Grid grid;
    private Presidential bob;
    private ArrayList<Barrier> barriers;
    private int score;
    private ArrayList<Votes> votes;
    

    public Election() {
        this.setBackground(ResourceTools.loadImageFromResource("snekysnek/goodbless.jpg"));

        grid = new Grid(35, 25, 20, 20, new Point(10, 50), Color.BLACK);
        bob = new Presidential(Direction.RIGHT, grid, this);

        barriers = new ArrayList<>();
        barriers.add(new Barrier(0, 0, Color.BLUE, this));
        createBarrierRange(0, 0, 0, grid.getRows() - 1, Color.RED);
        createBarrierRange(grid.getColumns() - 1, 0, grid.getColumns() - 1, grid.getRows() - 1, Color.BLUE);
        createBarrierRange(0, 0, grid.getColumns() - 1, 0, Color.BLUE);
        createBarrierRange(0, grid.getRows() - 1, grid.getColumns() - 1, grid.getRows() - 1, Color.WHITE);
        setUpSound();
        
        votes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            votes.add(new Votes(getRandomGridLocation(), getRandomInt(1, 17), this));
        }
        
    }
    
    public Point getRandomGridLocation(){
        return new Point(getRandomInt(1, grid.getColumns() - 2), getRandomInt(1, grid.getRows() - 2));
    }
    
    public int getRandomInt(int min, int max){
        return (int) (min + (Math.random() * (max - min + 1)));
    }

    SoundManager soundManager;
    public static final String SOUND_PICKAXE = "PICKAXE";

    private void setUpSound() {
        //set up a list of tracks in a playlist
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("SOUND_PICKAXE", Source.RESOURCE, "/snekysnek/Pickaxe.wav"));

        Playlist playlist = new Playlist(tracks);
        //pass the playlist to a sound manager
        soundManager = new SoundManager(playlist);
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
    int moveDelayLimit = 2;

    @Override
    public void timerTaskHandler() {

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
//            soundManager.play(SOUND_PICKAXE, 3);
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
        }
        
        if (votes != null) {
            for (Votes vote : votes) {
                vote.draw(graphics);
            }
        }
        
        
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Calibri", Font.BOLD, 25));
        graphics.drawString("Score: " + score++, 10, 20);

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


    @Override
    public Point validateMove(Point proposedLocation) {
        if (proposedLocation.x < 0) {
            proposedLocation.x = grid.getColumns() - 1;

        } else if (proposedLocation.x > grid.getColumns() - 1) {
            proposedLocation.x = 0;
        } else if (proposedLocation.y < 0) {
            proposedLocation.y = grid.getRows() - 1;
        } else if (proposedLocation.y > grid.getRows() - 1) {
            proposedLocation.y = 0;

        }

        return proposedLocation;

    }

}
