package model;

public class Square {

    // corners
    private int topLeft;
    private int topRight;
    private int bottomLeft;
    private int bottomRight;

    public Square(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public int getTopLeft() {
        return topLeft;
    }

    public int getTopRight() {
        return topRight;
    }

    public int getBottomLeft() {
        return bottomLeft;
    }

    public int getBottomRight() {
        return bottomRight;
    }

    public String toString() {
        return Integer.toString(getTopLeft()) + ' ' + getTopRight() + ' ' + getBottomLeft() + ' ' + getBottomRight();
    }

}
