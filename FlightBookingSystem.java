import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class FlightBookingSystem{
    // declearing an  flightsCounts for flights and tickets
    private int flightsCounts=0,ticketsflightsCounts;
    // delcearing an array of flights to store the flights info in it
    public Flight[] flights = new Flight[100];
    // delcearing an array of tickets to store the tickets info in it
    public Ticket[] tickets = new Ticket[100];

    // method to add flight into array flights
    public void addFlight(Flight flight){
        flights[flightsCounts] = flight;
        flightsCounts++;
    }    
    // add the ticket to array of tickets
    public void addTicket(Ticket ticket){
        tickets[ticketsflightsCounts] = ticket;
        ticketsflightsCounts++;
    }
    // method to check if flight exist and return the flight that was searched for
    public Flight findFlight(String flightNUM)throws Exception{
        for(int i =0;i<flightsCounts;i++){
            // check if flight exist by checking if the flight num equals flight num of one of the flights in the array
            if(flightNUM.equals(flights[i].getflightNum())){
                return flights[i];
            }
        }
        // return null if doesnt exist
        throw new Exception("flight not found.");
    }   
    public Ticket findTicket(String name,String flightNum) throws Exception{
        for(int i=0; i<ticketsflightsCounts;i++){
            // check if ticket in the array and return the ticket if found any ticket with the same name and same flight num
            if (tickets[i].getName().equals(name) && tickets[i].getFlightNum().equals(flightNum))
              return tickets[i];                  
        }
        throw new Exception("no ticket found");
    }
    // boolean method to check if flight exists and return true or return flase if its not
    public boolean flightExists(String flightNUM){  
        for(int i =0;i<flightsCounts;i++){
            // check if flight exist by checking if the flight num equals flight num of one of the flights in the array
            if(flightNUM.equals(flights[i].getflightNum()))
                return true;
        }
        return false;
    }  
    // method type ticket it search for the ticket through its name and flight num
    
    // return the index of the flight
    public int indexOfFlight(String name) throws Exception{
        for(int i=0; i<flightsCounts;i++){
            if(name.equals(flights[i].getflightNum()))
                return i;
        }
        throw new Exception("no flight at this number");
    }
    // return the index of ticket
    public int indexOfTicket(String name,String flightNum) throws Exception{
        for(int i=0; i<ticketsflightsCounts;i++){
            if(name.equals(tickets[i].getName()) && flightNum.equals(tickets[i].getFlightNum()))
                return i;
        }
        throw new Exception("Error: ticket not found");
    }
    // method to cancel ticket through its name and num
    public void cancelTicket(String flightNum, String name)throws Exception{
        // store index of the ticket in integer it return -1 if ticket not found
        int i = indexOfTicket(name, flightNum);
        if(i < 0 )
            throw new Exception("no ticket at these name");
        // if ticket found it remove it from the array through its index
        else {
            tickets[i].cancel();
            ticketsflightsCounts--;
            // put the ticket we want to remove in the last index in the tickets reached
            tickets[i] = tickets[ticketsflightsCounts];
            tickets[ticketsflightsCounts] = null;
        }
    }    
    // method to print booked passengers it takes the flight num as parmeter and comper it with flight num of any flight in the array and if found one it checks flight num with tickets flight num and if found print the name of ticket
    public void printBookedPassengers(String flightNum) throws Exception{ 
        for(int i =0;i<flightsCounts;i++){
            if(flightNum.equals(flights[i].getflightNum())){
                System.out.println("Booked Passengers for Flight "+flightNum+":");
                for(int j=0;j<ticketsflightsCounts;j++)
                    if(flightNum.equals(tickets[j].getFlightNum()))
                        System.out.println("Passenger Name: "+tickets[j]);
            }
        }
    }
    // method to print all availlable flights simply the method checks if the flight still have tickets if yes it print its info
    public void printAvailableFlights(){
        if(flightsCounts <=0)
            System.out.println("Error: theres no flights.");

        else{
            System.out.println("Available Flights:");
            for(int i=0;i<flightsCounts;i++){
                if(flights[i].hasTickets()){
                    System.out.println(flights[i]);
                    System.out.println("------------------------------");
                }
                else 
                    continue;
            }
        }
    }
    public  void printInFile() throws FileNotFoundException{
        File file = new File("passengers.txt");
        PrintWriter output = new PrintWriter(file);
        for(int i = 0; i <ticketsflightsCounts;i++)
            output.println("Passnger name: "+tickets[i].getName());
        output.close();
    }

}