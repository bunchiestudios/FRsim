package com.bunchiestudios.util;

/**
 * Created by rdelfin on 12/19/16.
 */
public class Matrix2 {
    private Vector2 r1, r2;

    /**
     * Initializes matrix using two row vectors
     * @param r1 Row 1
     * @param r2 Row 2
     */
    public Matrix2(Vector2 r1, Vector2 r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public Vector2 times(Vector2 v) {
        return new Vector2(r1.dot(v), r2.dot(v));
    }

    public Matrix2 times(Matrix2 m) {
        Matrix2 mt = m.transpose();
        return new Matrix2(new Vector2(r1.dot(mt.r1), r1.dot(mt.r2)),
                           new Vector2(r2.dot(mt.r1), r2.dot(mt.r2)));
    }

    public Matrix2 transpose() {
        return new Matrix2(new Vector2(r1.x, r2.x), new Vector2(r1.y, r2.y));
    }

    public static Matrix2 rotate(double theta) {
        return new Matrix2(new Vector2(Math.cos(theta), -Math.sin(theta)),
                           new Vector2(Math.sin(theta),  Math.cos(theta)));
    }
}
