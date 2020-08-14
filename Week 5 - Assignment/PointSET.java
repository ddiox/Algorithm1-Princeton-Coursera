import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

import java.awt.geom.Point2D;

public class PointSET {
    // Set of points in BST
    private SET<java.awt.geom.Point2D> points;

    // Construct an empty set of points
    public PointSET() {
        points = new SET<>();
    }

    // If the set empty
    public boolean isEmpty() {
        return points.isEmpty();
    }


    // Number of points in the set
    public int size() {
        return points.size();
    }


    // Add the point to the set (if it is not already in the set)
    public void insert(java.awt.geom.Point2D p) {
        if (p == null) {
            throw new NullPointerException("Can't add empty point");
        }

        points.add(p);
    }

    // If the set contain point p
    public boolean contains(java.awt.geom.Point2D p) {
        if (p == null) {
            throw new NullPointerException("Can't check empty point");
        }

        return points.contains(p);
    }

    // Draw all points to standard draw
    public void draw() {
        for (java.awt.geom.Point2D point : points) {
            point.draw();
        }
    }

    // All points that are inside the rectangle
    public Iterable<java.awt.geom.Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("Can't use empty rectangle");
        }

        Queue<java.awt.geom.Point2D> range = new java.util.Queue<>();

        for (java.awt.geom.Point2D point : points) {
            if (rect.contains(point)) {
                range.enqueue(point);
            }
        }

        return range;
    }

    // A nearest neighbor in the set to point p; null if the set is empty
    public java.awt.geom.Point2D nearest(java.awt.geom.Point2D p) {
        if (p == null) {
            throw new NullPointerException("Can't check empty point");
        }

        if (isEmpty()) {
            return null;
        }

        java.awt.geom.Point2D nearest = null;

        for (Point2D point : points) {
            if (nearest == null || (p.distanceTo(point) < p.distanceTo(nearest))) {
                nearest = point;
            }
        }

        return nearest;
    }

    // Unit testing of the methods (optional)
    public static void main(String[] args) {
        // To implement
    }
}
