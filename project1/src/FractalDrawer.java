
// Written by Owen Keating, keati090

import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {

    private double totalArea=0;

    public FractalDrawer() {}

    public double drawFractal(String type) {
        Canvas drawing = new Canvas(800,800);
        if(type.equals("Circle")||type.equals("circle")){
            drawCircleFractal(150,400,400, Color.BLACK, drawing, 7);
        }
        else if(type.equals("Triangle")||type.equals("triangle")){
            drawTriangleFractal(200,200,300,500, Color.BLACK, drawing, 7);
        }
        else if(type.equals("Rectangle")||type.equals("rectangle")){
            drawRectangleFractal(150,150,325,325, Color.BLACK, drawing, 7);
        }
        else{
            System.out.println("Invalid shape.");
        }
        return totalArea;
    }

    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if(level==7){
            Triangle myTriangle = new Triangle(x,y,width,height);
            myTriangle.setColor(Color.CYAN);
            can.drawShape(myTriangle);
            totalArea+=myTriangle.calculateArea();
            drawTriangleFractal(width,height,x,y,Color.CYAN,can,level-1);
        }
        else if(level==1){
            Triangle triangle1 = new Triangle(x-width/2,y,width/2,height/2);
            triangle1.setColor(Color.CYAN);
            can.drawShape(triangle1);
            totalArea+=triangle1.calculateArea();
            Triangle triangle2 = new Triangle(x+width,y,width/2,height/2);
            triangle2.setColor(Color.CYAN);
            can.drawShape(triangle2);
            totalArea+=triangle2.calculateArea();
            Triangle triangle3 = new Triangle(x+width/2-width/4,y-height,width/2,height/2);
            triangle3.setColor(Color.CYAN);
            can.drawShape(triangle3);
            totalArea+=triangle3.calculateArea();
        }
        else{
            Color cl = c;
            if(level%3==2){
                cl = Color.YELLOW;
            }
            if(level%3==1){
                cl = Color.CYAN;
            }
            if(level%3==0){
                cl = Color.MAGENTA;
            }
            Triangle triangle1 = new Triangle(x-width/2,y,width/2,height/2);
            triangle1.setColor(cl);
            can.drawShape(triangle1);
            totalArea+=triangle1.calculateArea();
            drawTriangleFractal(width/2,height/2,x-width/2,y,cl,can,level-1);
            Triangle triangle2 = new Triangle(x+width,y,width/2,height/2);
            triangle2.setColor(cl);
            can.drawShape(triangle2);
            totalArea+=triangle2.calculateArea();
            drawTriangleFractal(width/2,height/2,x+width,y,cl,can,level-1);
            Triangle triangle3 = new Triangle(x+width/2-width/4,y-height,width/2,height/2);
            triangle3.setColor(cl);
            can.drawShape(triangle3);
            totalArea+=triangle3.calculateArea();
            drawTriangleFractal(width/2,height/2,x+width/2-width/4,y-height,cl,can,level-1);
        }
    }

    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        double distance = (Math.sqrt(radius*radius/8)+Math.sqrt(radius*radius/2));
        if(level==7){
            Circle myCircle = new Circle(x,y,radius);
            myCircle.setColor(Color.CYAN);
            can.drawShape(myCircle);
            totalArea+=myCircle.calculateArea();
            drawCircleFractal(radius,x,y,Color.CYAN,can,level-1);
        }
        else if(level==1){
            Circle circle1 = new Circle(x-distance,y-distance,radius/2);
            circle1.setColor(Color.CYAN);
            can.drawShape(circle1);
            totalArea+=circle1.calculateArea();
            Circle circle2 = new Circle(x-distance,y+distance,radius/2);
            circle2.setColor(Color.CYAN);
            can.drawShape(circle2);
            totalArea+=circle2.calculateArea();
            Circle circle3 = new Circle(x+distance,y-distance,radius/2);
            circle3.setColor(Color.CYAN);
            can.drawShape(circle3);
            totalArea+=circle3.calculateArea();
            Circle circle4 = new Circle(x+distance,y+distance,radius/2);
            circle4.setColor(Color.CYAN);
            can.drawShape(circle4);
            totalArea+=circle4.calculateArea();
        }
        else{
            Color cl = c;
            if(level%3==2){
                cl = Color.MAGENTA;
            }
            if(level%3==1){
                cl = Color.CYAN;
            }
            if(level%3==0){
                cl = Color.ORANGE;
            }
            Circle circle1 = new Circle(x-distance,y-distance,radius/2);
            circle1.setColor(cl);
            can.drawShape(circle1);
            totalArea+=circle1.calculateArea();
            drawCircleFractal(radius/2,x-distance,y-distance,cl,can,level-1);
            Circle circle2 = new Circle(x-distance,y+distance,radius/2);
            circle2.setColor(cl);
            can.drawShape(circle2);
            totalArea+=circle2.calculateArea();
            drawCircleFractal(radius/2,x-distance,y+distance,cl,can,level-1);
            Circle circle3 = new Circle(x+distance,y-distance,radius/2);
            circle3.setColor(cl);
            can.drawShape(circle3);
            totalArea+=circle3.calculateArea();
            drawCircleFractal(radius/2,x+distance,y-distance,cl,can,level-1);
            Circle circle4 = new Circle(x+distance,y+distance,radius/2);
            circle4.setColor(cl);
            can.drawShape(circle4);
            totalArea+=circle4.calculateArea();
            drawCircleFractal(radius/2,x+distance,y+distance,cl,can,level-1);
        }
    }

    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if(level==7){
            Rectangle myRectangle = new Rectangle(x,y,width,height);
            myRectangle.setColor(Color.RED);
            can.drawShape(myRectangle);
            totalArea+=myRectangle.calculateArea();
            drawRectangleFractal(width,height,x,y,Color.RED,can,level-1);
        }
        else if(level==1){
            Rectangle rectangle1 = new Rectangle(x-(3.0/4.0*width),y-(3.0/4.0*height),width/2,height/2);
            rectangle1.setColor(Color.RED);
            can.drawShape(rectangle1);
            totalArea+=rectangle1.calculateArea();
            Rectangle rectangle2 = new Rectangle(x-(3.0/4.0*width),y+(5.0/4.0*height),width/2,height/2);
            rectangle2.setColor(Color.RED);
            can.drawShape(rectangle2);
            totalArea+=rectangle2.calculateArea();
            Rectangle rectangle3 = new Rectangle(x+(5.0/4.0*width),y-(3.0/4.0*height),width/2,height/2);
            rectangle3.setColor(Color.RED);
            can.drawShape(rectangle3);
            totalArea+=rectangle3.calculateArea();
            Rectangle rectangle4 = new Rectangle(x+(5.0/4.0*width),y+(5.0/4.0*height),width/2,height/2);
            rectangle4.setColor(Color.RED);
            can.drawShape(rectangle4);
            totalArea+=rectangle4.calculateArea();
        }
        else{
            Color cl = c;
            if(level%3==2){
                cl = Color.BLUE;
            }
            if(level%3==1){
                cl = Color.RED;
            }
            if(level%3==0){
                cl = Color.GREEN;
            }
            Rectangle rectangle1 = new Rectangle(x-(3.0/4.0*width),y-(3.0/4.0*height),width/2,height/2);
            rectangle1.setColor(cl);
            can.drawShape(rectangle1);
            totalArea+=rectangle1.calculateArea();
            drawRectangleFractal(width/2,height/2,x-(3.0/4.0*width),y-(3.0/4.0*height),cl,can,level-1);
            Rectangle rectangle2 = new Rectangle(x-(3.0/4.0*width),y+(5.0/4.0*height),width/2,height/2);
            rectangle2.setColor(cl);
            can.drawShape(rectangle2);
            totalArea+=rectangle2.calculateArea();
            drawRectangleFractal(width/2,height/2,x-(3.0/4.0*width),y+(5.0/4.0*height),cl,can,level-1);
            Rectangle rectangle3 = new Rectangle(x+(5.0/4.0*width),y-(3.0/4.0*height),width/2,height/2);
            rectangle3.setColor(cl);
            can.drawShape(rectangle3);
            totalArea+=rectangle3.calculateArea();
            drawRectangleFractal(width/2,height/2,x+(5.0/4.0*width),y-(3.0/4.0*height),cl,can,level-1);
            Rectangle rectangle4 = new Rectangle(x+(5.0/4.0*width),y+(5.0/4.0*height),width/2,height/2);
            rectangle4.setColor(cl);
            can.drawShape(rectangle4);
            totalArea+=rectangle4.calculateArea();
            drawRectangleFractal(width/2,height/2,x+(5.0/4.0*width),y+(5.0/4.0*height),cl,can,level-1);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        FractalDrawer fd = new FractalDrawer();
        String type = "";
        System.out.print("Shape? ");
        type = s.nextLine();
        double area = fd.drawFractal(type);
        System.out.println("Total Area: " + area);
    }

}
