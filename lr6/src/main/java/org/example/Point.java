package org.example;

public class Point {
    private double x;
    private double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point copy() {
        return new Point(x, y);
    }

    /** Сдвиг на (dx, dy). */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /** Поворот точки вокруг центра на degrees градусов. */
    public void rotateAround(Point center, double degrees) {
        double radians = Math.toRadians(degrees);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double tx = x - center.x;
        double ty = y - center.y;
        double rx = tx * cos - ty * sin;
        double ry = tx * sin + ty * cos;
        this.x = center.x + rx;
        this.y = center.y + ry;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


