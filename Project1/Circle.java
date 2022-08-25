// Written by Joshua Li, li002380
import java.awt.Color;
public class Circle{
    private double xposition;
    private double yposition;
    private double radius;
    private Color colorchoice;
    public Circle(double xpos, double ypos, double rad){
        xposition = xpos;
        yposition = ypos;
        radius = rad;
    }
    public double calculatePerimeter(){
        return(radius * 2 * 3.14159265);
    }
    public double calculateArea(){
        return(radius * radius * 3.14159265);
    }
    public void setColor(Color setcolor){
        colorchoice = setcolor;
    }
    public void setPos(double setx, double sety){
        xposition = setx;
        yposition = sety;
    }
    public void setRadius(double setrad){
        radius = setrad;
    }
    public Color getColor(){
        return colorchoice;
    }
    public double getXPos(){
        return xposition;
    }
    public double getYPos(){
        return yposition;
    }
    public double getRadius(){
        return radius;
    }
    public static void main(String[] args){ 
        Circle myCircle = new Circle(0, 0, 3);
        System.out.println(myCircle.calculatePerimeter());
    }
}