package com.bunchiestudios.util;

/**
 * Class represents a 2-Dimensional vector, with all the most common operations
 */
public class Vector2 {
    /**
     * X coordinate of the vector
     */
    public double x;

    /**
     * Y Coordinate of the vector
     */
    public double y;

    /**
     * Main constructor that accepts two coordinates
     * @param x X-Coordinate
     * @param y Y-Coordinate
     */
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initialized Vector to the zero vector (0, 0)
     */
    public Vector2() {
        this(0, 0);
    }

    /**
     * Initializes both coordinates to the same value
     * @param v Value such that the vector becomes (v, v)
     */
    public Vector2(double v) {
        this(v, v);
    }

    /**
     * Initialize using a different vector
     * @param v Vector to copy
     */
    public Vector2(Vector2 v) {
        this(v.x, v.y);
    }

    /**
     * Add two vectors together.
     * @param v Vector to add onto this vector
     * @return The vector addition of this and v
     */
    public Vector2 add(Vector2 v) {
        return new Vector2(x + v.x, y + v.y);
    }

    /**
     * Add this vector and a scalar by adding the value of the scalar to each coordinate of the fector
     * @param val Value to be added onto
     * @return The addition of the value and this vector
     */
    public Vector2 add(double val) {
        return new Vector2(x+val, y+val);
    }

    /**
     * Subract the second vector from this vector
     * @param v Vector being subtracted
     * @return The vector subraction: this - v
     */
    public Vector2 sub(Vector2 v) {
        return new Vector2(x - v.x, y - v.y);
    }

    /**
     * Scale the vector by the parameter
     * @param s Value to scale by
     * @return s*this vector
     */
    public Vector2 scale(double s) {
        return new Vector2(s*x, s*y);
    }

    /**
     * Calculates the negative vector (ie scaling by -1)
     * @return this*-1
     */
    public Vector2 neg() {
        return scale(-1);
    }

    /**
     * The length of the vector
     * @return sqrt(dot(this, this))
     */
    public double length() {
        return Math.sqrt(dot(this));
    }

    /**
     * Obtains the angle of this vector
     * @return The angle, using atan2()
     */
    public double theta() {
        return Math.atan2(y, x);
    }

    /**
     * Gets the dot product of this vector and some other vector
     * @param v The second vector for the dot product
     * @return dot(this, v)
     */
    public double dot(Vector2 v) {
        return x*v.x + y*v.y;
    }
}
