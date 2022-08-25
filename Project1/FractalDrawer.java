// FractalDrawer class draws a fractal of a shape indicated by user input
// Written by Joshua Li, li002380
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;
public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area
    public FractalDrawer() {}  // contructor
    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type){
        Canvas drawing = new Canvas(1000,1000);
        if (type.equalsIgnoreCase("circle")){ // Meant to account for lower and upper case discrepancy between users
            drawCircleFractal(100,500,500, Color.BLUE, drawing, 8);
        }
        else if (type.equalsIgnoreCase("triangle")){
            drawTriangleFractal(160, 180, 420, 550, Color.ORANGE, drawing, 8);
        }
        else if (type.equalsIgnoreCase("rectangle")){
            drawRectangleFractal(140, 100 , 430, 450, Color.MAGENTA, drawing, 8);
        }
        else{
            System.out.println("Invalid Shape!"); // To account for potential mistypes or mistakes
        }
        return totalArea;
    }
    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double 
y, Color c, Canvas can, int level){
        if(level <= 0){
            return; // End of Recusive loop
        }
        else{
            level -= 1; // Termination sequence based on levels
            if(level == 7){ // Sequence of if statements changes color based on each different level
                c = Color.GREEN;
            }
            else if(level == 6){
                c = Color.ORANGE;
            }
            else if(level == 5){
                c = Color.BLUE;
            }
            else if(level == 4){
                c = Color.MAGENTA;
            }
            else if(level == 3){
                c = Color.YELLOW;
            }
            else if(level == 2){
                c = Color.BLACK;
            }
            else if(level == 1){
                c = Color.RED;
            }
            else {
                c = Color.GRAY;
            }
            Triangle myTriangle = new Triangle(x, y, width, height);
            myTriangle.setColor(c);
            can.drawShape(myTriangle);
            totalArea += myTriangle.calculateArea(); // Adds calculated area of each shape using its class' method to global method total area
            drawTriangleFractal(width * 0.55, height * 0.55, x - (width * 0.55), y, c, can, level); // Left Corner
            drawTriangleFractal(width * 0.55, height * 0.55, x + width, y, c, can, level); // Right Corner
            drawTriangleFractal(width * 0.55, height * 0.55, x + (width / 2) - (width * 0.55) / 2, y - height, c, can, level); // Top Corner
        }
    }
    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, 
Canvas can, int level){
        if(level <= 0){
            return; // End of Recusive loop
        }
        else {
            level -= 1; // Termination sequence based on levels
            if(level == 7){
                c = Color.GREEN;
            }
            else if(level == 6){
                c = Color.ORANGE;
            }
            else if(level == 5){
                c = Color.BLUE;
            }
            else if(level == 4){
                c = Color.MAGENTA;
            }
            else if(level == 3){
                c = Color.YELLOW;
            }
            else if(level == 2){
                c = Color.BLACK;
            }
            else if(level == 1){
                c = Color.RED;
            }
            else {
                c = Color.GRAY;
            }
            Circle myCircle = new Circle(x, y, radius);
            myCircle.setColor(c);
            can.drawShape(myCircle);
            totalArea += myCircle.calculateArea();
            drawCircleFractal(radius * 0.55, x - radius, y - radius, c, can, level); // Third Quadrant Circle
            drawCircleFractal(radius * 0.55, x + radius, y - radius, c, can, level); // Fourth Quadrant Circle
            drawCircleFractal(radius * 0.55, x + radius, y + radius, c, can, level); // First Quadrant Circle
            drawCircleFractal(radius * 0.55, x - radius, y + radius, c, can, level); // Second Quadrant Circle
        }
    }
    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double 
y, Color c, Canvas can, int level){
        if(level <= 0){
            return; // End of Recusive loop
        }
        else {
            level -= 1; // Termination sequence based on levels
            Random random = new Random();
            int random1 = random.ints(0, 255).findFirst().getAsInt(); // Generates three random integers between 0 to 255
            int random2 = random.ints(0, 255).findFirst().getAsInt();
            int random3 = random.ints(0, 255).findFirst().getAsInt();
            c = new Color(random1, random2, random3); // Inserts random integer to generate a random color
            // This random generates a new color each repitition not each level
            Rectangle myRectangle = new Rectangle(x, y, width, height);
            myRectangle.setColor(c);
            can.drawShape(myRectangle);
            totalArea += myRectangle.calculateArea();
            drawRectangleFractal(width * 0.6, height * 0.6, x - (width * 0.6), y - (height * 0.6), c, can, level); // Upper Left Corner
            drawRectangleFractal(width * 0.6, height * 0.6, x + width, y - (height * 0.6), c, can, level); // Upper Right Corner
            drawRectangleFractal(width * 0.6, height * 0.6, x - (width * 0.6), y + height, c, can, level); // Lower Left Corner
            drawRectangleFractal(width * 0.6, height * 0.6, x + width, y + height, c, can, level); // Lower Right Corner
        }
    }
    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        System.out.println("Choose (Circle), (Triangle), (Rectangle): ");
		Scanner myScanner = new Scanner(System.in);
		String input = myScanner.nextLine();
        FractalDrawer myFractalDrawer = new FractalDrawer();
        double totalArea1 = myFractalDrawer.drawFractal(input);
        System.out.println("Total Area of the Fractal: " + totalArea1);
    }
}