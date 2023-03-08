
// Written by Owen Keating, keati090

import java.awt.Color;

public class Circle {

    private double xpos;
    private double ypos;
    private double radius;
    private Color color;

    public Circle(double x, double y, double r){
        xpos = x;
        ypos = y;
        radius = r;
        color = Color.BLACK;
    }

    public double calculatePerimeter(){
        return radius*2*Math.PI;
    }

    public double calculateArea(){
        return radius*radius*Math.PI;
    }

    public void setColor(Color c){
        color = c;
    }

    public void setPos(double x, double y){
        xpos = x;
        ypos = y;
    }

    public void setRadius(double r){
        radius = r;
    }

    public Color getColor(){
        return color;
    }

    public double getXPos(){
        return xpos;
    }

    public double getYPos(){
        return ypos;
    }

    public double getRadius(){
        return radius;
    }

}
