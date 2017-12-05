package com.aphoot.adventofcode2017;

public class Point {
    int x;
    int y;

    Point( int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Point)obj).x == this.x && ((Point)obj).y == this.y;
    }

    @Override
    public int hashCode() {
        return this.x*1024*1024 + this.y;
    }
}
