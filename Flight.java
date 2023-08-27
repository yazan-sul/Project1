public class Flight{
    private String flightNum;
    private String destination;
    private String originAirport;
    private String departureDate;
    private String departureTime;
    private int numOfTickets;
    private int ticketPrice;
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
    public boolean hasTickets(){
        if(numOfTickets>0){
            return true;
        }
        else 
            return false;
    }
    public void oneTicket(){
        numOfTickets--;
    }
}