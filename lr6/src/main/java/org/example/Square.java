package org.example;
import java.awt.Color;

public class Square {
    private Point center;
    private double side; // текущая длина стороны
    private double rotationDegrees; // угол поворота относительно осей (в градусах)
    private Color color;
    public Segment segment;

    public Square(Segment segment, Point center) {
        this.segment = segment;
        this.center = center;
    }


    public Square(Point center, double side) {
        if (center == null) throw new IllegalArgumentException("Center cannot be null");
        if (side <= 0) throw new IllegalArgumentException("Side must be positive");
        this.center = center.copy();
        this.side = side;
        this.rotationDegrees = 0;
        this.color = Color.BLACK;
    }


    public Point getCenter() {
        return center.copy();
    }

    public double getSide() {
        return side;
    }

    public double getRotationDegrees() {
        return rotationDegrees;
    }

    public Color getColor() {
        return color;
    }

    // Methods per assignment
    public void setSize(double newSide) {
        if (newSide <= 0) throw new IllegalArgumentException("Side must be positive");
        this.side = newSide;
    }

    public void stretch(double factor) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive");
        this.side *= factor;
    }

    public void compress(double factor) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive");
        this.side /= factor;
    }

    public void rotate(double degrees) {
        this.rotationDegrees = normalizeAngle(rotationDegrees + degrees);
    }

    public void setColor(Color color) {
        if (color == null) throw new IllegalArgumentException("Color cannot be null");
        this.color = color;
    }

    public Segment[] getEdges() {
        Point[] vertices = getVertices();
        return new Segment[]{
                new Segment(vertices[0], vertices[1]),
                new Segment(vertices[1], vertices[2]),
                new Segment(vertices[2], vertices[3]),
                new Segment(vertices[3], vertices[0])
        };
    }

    public Point[] getVertices() {
        double half = side / 2.0;
        Point p1 = new Point(center.getX() - half, center.getY() - half);
        Point p2 = new Point(center.getX() + half, center.getY() - half);
        Point p3 = new Point(center.getX() + half, center.getY() + half);
        Point p4 = new Point(center.getX() - half, center.getY() + half);
        // rotate around center
        p1.rotateAround(center, rotationDegrees);
        p2.rotateAround(center, rotationDegrees);
        p3.rotateAround(center, rotationDegrees);
        p4.rotateAround(center, rotationDegrees);
        return new Point[]{p1, p2, p3, p4};
    }

    private static double normalizeAngle(double degrees) {
        double angle = degrees % 360.0;
        return angle < 0 ? angle + 360.0 : angle;
    }

    @Override
    public String toString() {
        return "Square{center=" + center + ", side=" + side +
                ", rotation=" + rotationDegrees + ", color=#" + Integer.toHexString(color.getRGB()).toUpperCase() + "}";
    }
}


