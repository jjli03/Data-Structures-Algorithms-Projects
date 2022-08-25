// Written by Joshua Li, li002380
import java.awt.Color;
public class Rectangle{
    private double xposition;
    private double yposition;
    private double width;
    private double height;
    private Color colorchoice;
    public Rectangle(double xpos, double ypos, double wide, double tall){
        xposition = xpos;
        yposition = ypos;
        width = wide;
        height = tall;
    }
    public double calculatePerimeter(){
        return(width * 2 + height * 2);
    }
    public double calculateArea(){
        return(width * height);
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
        Rectangle myRectangle = new Rectangle(0, 0, 3, 3); 
        System.out.println(myRectangle.calculatePerimeter() + " " + myRectangle.getHeight());
    }
}