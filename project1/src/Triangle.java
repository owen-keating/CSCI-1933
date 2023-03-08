
// Written by Owen Keating, keati090

import java.awt.Color;

public class Triangle {

    private double xpos;
    private double ypos;
    private double width;
    private double height;
    private Color color;

    public Triangle(double x, double y, double w, double h){
        xpos = x;
        ypos = y;
        width = w;
        height = h;
        color = Color.BLACK;
    }

    public double calculatePerimeter(){
        double length = Math.sqrt(Math.pow((width/2),(2.0))+Math.pow(height,2.0));
        return 2.0*length+width;
    }

    public double calculateArea(){
        return 0.5*width*height;
    }

    public void setColor(Color c){
        color = c;
    }

    public void setPos(double x, double y){
        xpos = x;
        ypos = y;
    }

    public void setHeight(double h){
        height = h;
    }

    public void setWidth(double w){
        width = w;
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

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

}
