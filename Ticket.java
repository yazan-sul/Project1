public class Ticket{

    private String custmorName;
    private Flight flight;
    
    public Ticket(String custmorName,Flight flight){
        this.custmorName = custmorName;
        this.flight = flight;
    }
    public Ticket(String custmorName,String flightNum){
        this.custmorName = custmorName;
        this.flightNum = flight.getflightNum();

    }
    public void updateCustomerName(String custmorName){
        this.custmorName = custmorName;
    }
    public String toString(){
        return  custmorName; 
    }


}
