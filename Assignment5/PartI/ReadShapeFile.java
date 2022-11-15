import java.io.*;
import java.util.ArrayList;

import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */

public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) throws ShapeException {
		
		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
		  if(shapeName.equals("Circle")){
		       return new Circle();
		   }
		   else if(shapeName.equals("Square")){
		       return new Square();
		   }
		   else if(shapeName.equals("Rectangle")){
		       return new Rectangle();
		   }
		   else{
			   throw new ShapeException(shapeName);
			   }
	}
	
	public static void main(String[] args){
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		
		String inString = null;
		System.out.println("Entering try statement");
        RandomAccessFile newissue= null;
        try {
			newissue = new RandomAccessFile(f, "r");
		} catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}
		/* create a loop to read the file line-by-line */
   try {
	while ((inString = newissue.readLine()) != null) {	
			try {
				GeometricObject shape = createShape(inString);
				//System.out.println(shape);
				shapeList.add(shape);
			} catch (ShapeException e ) {
				System.err.println("Cannot create shape: " + inString);
				continue;
			}	
			
		}
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  int length = shapeList.size();
  for(int i=0;i<=length-3;i++) {
	  System.out.println(shapeList.get(i));
  }
 
}
}
