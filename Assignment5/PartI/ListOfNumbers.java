import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private List<Integer> list;
    private String inFile;
    private static final int SIZE = 100;
    
    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
    }
    

    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;	
    }
    
    public void readList() {
    	  BufferedReader in = null;
          try {
                  System.out.println("Entering try statement");
                  in = new BufferedReader(new FileReader("numberfile.txt"));
                  String newline = null;
                  while ((newline = in.readLine()) != null) { // read line by line
                          System.out.println("there is a new line: " + newline);
                          int temp = Integer.parseInt(newline); // transfer to int
                          list.add(temp); // add the new line to the list
                  }
          } catch (IOException e) {
                  System.err.println("we have an IOException: " + e.getMessage());
          } finally {
                  if (in != null) {
                          System.out.println("Close the buffer");
                          try {
                                  in.close();
                          } catch (IOException e) {
                                  e.printStackTrace();
                          }
                  } else {
                          System.out.println("buffer is not work");
                  }
          }
    }
    
    public void writeList() {
    	PrintWriter out = null;
    try {
    	System.out.println("Entering try statement");
    	out = new PrintWriter(new FileWriter("outFile.txt"));
    	for (int i = 0; i < SIZE; i++)
    	out.println("Value at: " + i + " = " + list.get(i));
    } catch (IndexOutOfBoundsException e) {
    	System.err.println("Caught IndexOutOfBoundsException: " +
    	e.getMessage());
    } catch (IOException e) {
        System.err.println("Caught IOException: " + e.getMessage());
    	} finally {
    	if (out != null) {
    	System.out.println("Closing PrintWriter");
    	out.close();
    	} else {
         System.out.println("PrintWriter not open");
         }
    	}
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        }
            catch(IOException e){
            	System.err.println("we have an IOException: " + e.getMessage());
            	return;
            }
       finally {
            if (input != null) {
                try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();
    }

}
