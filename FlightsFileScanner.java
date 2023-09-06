import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// class to read flights info from a file 
public class FlightsFileScanner {
    // declearing a scanner for the class
    private Scanner scanner;
    // constructer that takes file name or file path and put the scanner to read from it
    FlightsFileScanner(String fileName) throws FileNotFoundException{
        File flightsFile = new File(fileName);
        this.scanner = new Scanner(flightsFile);
    }
    // reads the info of the flight and split it by , and put the info in a flight
    // its important that the info be sorted as the example you gave.
    public Flight readFlight() throws NumberFormatException {
        String[] tokens = scanner.nextLine().split(",");
        return new Flight(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
    }
    // method to check if theres a nextline in file
    public boolean hasNextFlight() {
        return scanner.hasNextLine();
    }
    // method to close the sccaner
    public void close() {
        scanner.close();
    }
}