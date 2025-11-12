package org.example;

public class Segment {
    private Point a;
    private Point b;

    public Segment(Point a, Point b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }
        this.a = a.copy();
        this.b = b.copy();
    }

    public Point getA() {
        return a.copy();
    }

    public Point getB() {
        return b.copy();
    }

    public double length() {
        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        return Math.hypot(dx, dy);
    }

    public void translate(double dx, double dy) {
        a.translate(dx, dy);
        b.translate(dx, dy);
    }

    public void rotateAround(Point center, double degrees) {
        a.rotateAround(center, degrees);
        b.rotateAround(center, degrees);
    }
}


