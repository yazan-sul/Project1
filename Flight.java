// class flight
public class Flight{
    // flight data fields
    private String flightNum;
    private String destination;
    private String originAirport;
    private String departureDate;
    private String departureTime;
    private int numOfTickets;
    private int ticketPrice;
    // constructer to put the info to the flight obj
    public Flight(String flightNum,String destination,String originAirport,String departureDate,String departureTime,int numOfTickets,int ticketPrice)
    {
        this.flightNum = flightNum;
        this.destination = destination;
        this.originAirport = originAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.numOfTickets = numOfTickets;
        this.ticketPrice = ticketPrice;
    }
    
    // boolean method to check if flight have tickets left it return true and if no it return false
    public  boolean hasTickets()
    {
        if(numOfTickets==0){
            return false;
        }
        return true;
    }
    // method to book ticket it checks if the object have tickets left first then it book a ticket and store the ticket with the info of flight and its name
    public Ticket bookTicket(String name) throws FlightFullException
    {        
        if(!this.hasTickets())
            throw new FlightFullException("NO TICKETS");

        this.numOfTickets--;
        return new Ticket(name,this);
    
    }
    // method to add a ticket to its object when deleted 
    public void deleteTicket(){
        this.numOfTickets++;
    }    
    // method to return a string of flight info
    public String toString(){
        return "Flight Number: "+flightNum+"\nOrigin: "+this.originAirport + "\nDestination: "+ this.destination+ "\nDeparture Date: "+ departureDate+ "\nDeparture Time: "+departureTime+ "\nAvailable Tickets: "+ numOfTickets+ "\nTicket Price: $"+ ticketPrice;
    }
    // getter for flight num
    public String getflightNum(){
        return flightNum;
    }
    // getter for num of tickets
    public int getNumOfTickets(){
        return numOfTickets;
    }
}