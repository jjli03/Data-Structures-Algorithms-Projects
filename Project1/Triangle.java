// Written by Joshua Li, li002380
import java.awt.Color;
import static java.lang.Math.*;
public class Triangle{
    private double xposition;
    private double yposition;
    private double width;
    private double height;
    private Color colorchoice;
    public Triangle(double xpos, double ypos, double wide, double tall){
        xposition = xpos;
        yposition = ypos;
        width = wide;
        height = tall;
    }
    public double calculatePerimeter(){
        return Math.pow((Math.pow((width / 2), 2) + Math.pow(height, 2)), 0.5) * 2 + width;
    }
    public double calculateArea(){
        return(width * height / 2);
    }
    public void setColor(Color setcolor){
        colorchoice = setcolor;
    }
    public void setPos(double setx, double sety){
        xposition = setx;
        yposition = sety;
    }
    public void setHeight(double setheight){
        height = setheight;
    }
    public void setWidth(double setwidth){
        width = setwidth;
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
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
    public static void main(String[] args){
        Triangle myTriangle = new Triangle(0, 0, 6, 4); 
        System.out.println(myTriangle.calculatePerimeter() + " " + myTriangle.getHeight());
    }
}