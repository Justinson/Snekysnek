/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snekysnek;

import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Justinson
 */
public class Presidential {

    /**
     * @return the HEAD_POSITION
     */
    public static int getHEAD_POSITION() {
        return HEAD_POSITION;
    }

    /**
     * @param aHEAD_POSITION the HEAD_POSITION to set
     */
    public static void setHEAD_POSITION(int aHEAD_POSITION) {
        HEAD_POSITION = aHEAD_POSITION;
    }
    private MoveValidatorIntf validator;

    public Presidential(Direction direction, Grid grid, MoveValidatorIntf validator) {

        this.direction = direction;
        this.grid = grid;
        this.validator = validator;

        //create the body of the snake
        body = new ArrayList<>();
        body.add(new Point(5, 5));
        body.add(new Point(5, 4));
        body.add(new Point(5, 3));
        body.add(new Point(5, 2));
        body.add(new Point(4, 2));
        body.add(new Point(3, 2));

    }

    private Direction direction = Direction.LEFT;
    private ArrayList<Point> body;
    private Grid grid;
    private Color bodyColor = Color.BLUE;

    public void draw(Graphics graphics) {
        graphics.setColor(getBodyColor());
        for (int i = 0; i < getBody().size(); i++) {
            graphics.fillOval(getGrid().getCellSystemCoordinate(getBody().get(i)).x,
                    getGrid().getCellSystemCoordinate(getBody().get(i)).y,
                    getGrid().getCellWidth(),
                    getGrid().getCellHeight());

        }

    }

    private static int HEAD_POSITION = 0;

    public void move() {
        //making a copy of the current head location        
        Point newHead = new Point(getHead());

        if (getDirection() == Direction.LEFT) {
            newHead.x--;
        } else if (getDirection() == Direction.RIGHT) {
            newHead.x++;
        } else if (getDirection() == Direction.DOWN) {
            newHead.y++;
        } else if (getDirection() == Direction.UP) {
            newHead.y--;
        }
        //add new head
        getBody().add(getHEAD_POSITION(), getValidator().validateMove(newHead));

        //DELETE TAIL
        getBody().remove(getBody().size() -1);
        {

        }

    }

    public Point getHead() {
        return getBody().get(getHEAD_POSITION());
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    /**
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * @return the bodyColor
     */
    public Color getBodyColor() {
        return bodyColor;
    }

    /**
     * @param bodyColor the bodyColor to set
     */
    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    /**
     * @return the validator
     */
    public MoveValidatorIntf getValidator() {
        return validator;
    }

    /**
     * @param validator the validator to set
     */
    public void setValidator(MoveValidatorIntf validator) {
        this.validator = validator;
    }

}
