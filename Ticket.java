// class ticket
public class Ticket{
    // ticket data fields
    private String custmorName;
    private Flight flight;
    // constructer to put the info to the ticket obj
    public Ticket(String custmorName,Flight flight){
        this.custmorName = custmorName;
        this.flight = flight;
    }
    // getter for custmorName
    public String getName(){
        return custmorName;
    }
    // setter for custmorName
    public void setName(String newName){
        this.custmorName = newName;
    }
    // method to get flight num from class flight throug object
    public String getFlightNum(){
        return this.flight.getflightNum();
    }
    // method to delet ticket through calling object then into class flight to call the method deleteTicket
    public void cancel(){
        this.flight.deleteTicket();
    }
    // method to get Num Of Tickets  from class flight throug object
    public int getNumOfTicketsFromFlight(){
        return this.flight.getNumOfTickets();
    }
}
