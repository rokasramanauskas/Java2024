
import java.lang.Math;
public class Main {

    public static void main(String[] args) {

        //sukuriu du kintamuosius Point duomenu tipo, kuris laiko x ir y
        Point p1 = new Point();
        Point p2 = new Point();

        //nustatom p1 ir p2 ixo ir ygriko reiksmes
        p1.setX(5);
        p1.setY(5);

        p2.setX(3);
        p2.setY(3);

        //sukuriam linija i kuria turim paduot du pointus
        Segment linija = new Segment();

        linija.setSegment(p1, p2);
        linija.print();
        linija.calculateDistance(p1, p2);

    }

}

class Point {
    //vieno tasko laikomos dvi koord
    private double x, y;

    //get set print
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    void print(){
        System.out.println(x + ", " + y);
    }

}

class Segment {

    private Point p1, p2;

    public void setSegment(Point taskas1, Point taskas2) {
        this.p1 = taskas1;
        this.p2 = taskas2;
    }

    public void print(){
        System.out.println("(" + p1.getX() + ", " + p1.getY() + ") ; (" + p2.getX() + ", " + p2.getY() + ")");
    }

    public void calculateDistance(Point taskas1, Point taskas2){
        double dx = Math.sqrt(Math.pow(taskas2.getX() - taskas1.getX(), 2) + Math.pow(taskas2.getY() - taskas1.getY(), 2));
        System.out.println(dx);

    }

}