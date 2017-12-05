package com.aphoot.adventofcode2017;

public class Turtle {
    /*
    Down = 0
    Right = 1
    Up = 2
    Left = 3
     */
    public int heading;

    public Point currentPosition;

    public Turtle(Point currentPosition, int heading){
        this.currentPosition = currentPosition;
        this.heading = heading;
    }

    public Point getLeftCoordinate(){
        int x = currentPosition.x;
        int y = currentPosition.y;

        if (heading == 0)
            x++;
        if (heading == 1)
            y++;
        if (heading == 2)
            x--;
        if (heading == 3)
            y--;
        return new Point(x,y);
    }

    public void turnLeft(){
        heading = (heading + 1)%4;
    }

    public void moveForward(){
        if (heading == 0)
            currentPosition = new Point(currentPosition.x, currentPosition.y-1);
        if (heading == 1)
            currentPosition = new Point(currentPosition.x+1, currentPosition.y);
        if (heading == 2)
            currentPosition = new Point(currentPosition.x, currentPosition.y+1);
        if (heading == 3)
            currentPosition = new Point(currentPosition.x-1, currentPosition.y);
    }
}
