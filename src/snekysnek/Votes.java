/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snekysnek;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Justinson
 */
public class Votes {

    //constructor
    public Votes(int x, int y, int voteCount, CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.voteCount = voteCount;
        this.cellData = cellData;
    }

    public Votes(Point location, int voteCount, CellDataProviderIntf cellData) {
        this.x = location.x;
        this.y = location.y;
        this.voteCount = voteCount;
        this.cellData = cellData;
    }

    //draw
    public void draw(Graphics graphics) {
        graphics.setFont(font);
        graphics.drawString("" + getVoteCount(), cellData.getSystemCoordX(getX(), getY()) + (cellData.getCellWidth() / 4),
                cellData.getSystemCoordY(getX(), getY()) + (cellData.getCellHeight() * 3 / 4));
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x;
    private int y;

    private int voteCount;
    private CellDataProviderIntf cellData;
    private static final Font font = new Font("Calibri", Font.BOLD, 18);

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the voteCount
     */
    public int getVoteCount() {
        return voteCount;
    }

    /**
     * @param voteCount the voteCount to set
     */
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
//</editor-fold>

}
