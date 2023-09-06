import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlightsFileScanner {
    private Scanner scanner;

    FlightsFileScanner(String fileName) throws FileNotFoundException{
        File flightsFile = new File(fileName);
        this.scanner = new Scanner(flightsFile);
    }
    public Flight readFlight() throws NumberFormatException {
        String[] tokens = scanner.nextLine().split(",");
        return new Flight(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
    }
    public boolean hasNextFlight() {
        return scanner.hasNextLine();
    }
    public void close() {
        scanner.close();
    }
}