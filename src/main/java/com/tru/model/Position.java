package com.tru.model;

import uk.me.jstott.jcoord.LatLng;
import uk.me.jstott.jcoord.UTMRef;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-04
 * @since 1.8
 */
public class Position {

    private double x;

    private double y;

    public Position(double latitude, double longitude) {
        LatLng latLng = new LatLng(latitude, longitude);
        UTMRef ref = latLng.toUTMRef();
        this.x = ref.getEasting();
        this.y = ref.getNorthing();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
