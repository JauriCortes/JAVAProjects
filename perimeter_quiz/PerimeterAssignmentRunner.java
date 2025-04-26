import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here   
        int numPoints = 0;     
        for (Point p : s.getPoints()) {
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter(s);
        double numPoints = getNumPoints(s);
        double average = perimeter / numPoints;
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double prevDist = 0;

        for (Point currPt : s.getPoints()) {

            double currDist = prevPt.distance(currPt);

            if (currDist > prevDist) {
                prevDist = currDist;
            }

            prevPt = currPt;
        }
        return prevDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        int currX = 0;
        for (Point currPt : s.getPoints()) {
            int x = currPt.getX();
            if (x > currX) {
                currX = x;
            }
        }
        return currX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for (File f : dr.selectedFiles()) {
            Shape s = new Shape(new FileResource(f));
            double perim = getPerimeter(s);
            if (perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File temp = null;

        for (File f : dr.selectedFiles()) {
            Shape s = new Shape(new FileResource(f));
            double perim = getPerimeter(s);
            if (perim > largestPerim) {
                largestPerim = perim;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        int numPoints = getNumPoints(s);
        System.out.println("Number of points = " + numPoints);

        double AverageLength = getAverageLength(s);
        System.out.println("Average = " + AverageLength);

        double LargerSide = getLargestSide(s);
        System.out.println("Largest side is = " + LargerSide);

        double LargestX = getLargestX(s);
        System.out.println("Largest X is = " + LargestX);

        //testPerimeterMultipleFiles();
        //testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perim is: " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largestFile = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter: " + largestFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
