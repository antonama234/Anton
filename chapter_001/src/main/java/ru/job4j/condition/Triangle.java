package ru.job4j.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    double poluper;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double period(double ab, double ac, double bc) {
       poluper = (ab + ac + bc) / 2;
       return poluper;
    }

    public double area() {
        double rsl = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
           rsl = Math.sqrt(poluper * (poluper - ab) * (poluper - ac) * (poluper - bc));
        }
        return rsl;
    }

    private boolean exist(double ab, double ac, double bc) {
        if ((ab + ac) > bc || (ab + bc) > ac || (ac + bc) > ab) {
            return true;
        }
        return false;
    }
}
