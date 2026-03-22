package ex01;

import java.io.Serializable;

public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;

    public double m, v, h, energy;
    public transient String bin;

    public Item2d(double m, double v, double h, double e) {
        this.m = m;
        this.v = v;
        this.h = h;
        this.energy = e;
        this.bin = Long.toBinaryString((long) e);
    }

    public double getY() {
        return energy;
    }

    public double getX() {
        return m;
    }

    public String toString() {
        return "Energiia: " + energy + ", Dvikovo: " + bin;
    }
}
