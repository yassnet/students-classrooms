package com.tru.util.model;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-04
 * @since 1.8
 */
public class Classroom {
    
    private String name;

    private Position position;

    private int width;
    private int height;

    private double maxXPosition;
    private double minXPosition;
    private double maxYPosition;
    private double minYPosition;


    public Classroom(String name, Position position, int width, int height) {
        this.name = name;
        this.position = position;
        this.width = width;
        this.height = height;
        this.maxXPosition = position.getX() + height/2;
        this.minXPosition = position.getX() - height/2;
        this.maxYPosition = position.getY() + height/2;
        this.minYPosition = position.getY() - height/2;
    }

    public double getMaxXPosition() {
        return maxXPosition;
    }

    public double getMinXPosition() {
        return minXPosition;
    }

    public double getMaxYPosition() {
        return maxYPosition;
    }

    public double getMinYPosition() {
        return minYPosition;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", width=" + width +
                ", height=" + height +
                ", maxXPosition=" + maxXPosition +
                ", minXPosition=" + minXPosition +
                ", maxYPosition=" + maxYPosition +
                ", minYPosition=" + minYPosition +
                '}';
    }
}
