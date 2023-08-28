public class Ticket{

    private String custmorName;
    private Flight flight;
    
    public Ticket(String custmorName,Flight flight){
        this.custmorName = custmorName;
        this.flight = flight;
    }
    public void updateCustomerName(String custmorName){
        this.custmorName = custmorName;
    }
    public String toString(){
        return  custmorName; 
    }
        
    public String getName(){
        return custmorName;
    }
    public void setName(String newName){
        this.custmorName = newName;
    }
}
