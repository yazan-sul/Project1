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
    public  boolean hasTickets(){
        if(numOfTickets!=0){
            return true;
        }
        else 
            return false;
    }
    public Ticket bookTicket(String name){
        if(this.hasTickets()){
            this.numOfTickets--;
            return new Ticket(name,this);
        }
        else
        {
            System.out.println("no tickets available");
            return new Ticket(null, null);
        }
    }    
    public String toString(){
        return flightNum;
    }
    public String getflightNum(){
        return flightNum;
    }
}