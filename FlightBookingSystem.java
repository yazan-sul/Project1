public class FlightBookingSystem{
    // declearing an  count for flights and tickets
    private int count=0,count1;
    // delcearing an array of flights to store the flights info in it
    public Flight[] flights = new Flight[100];
    // delcearing an array of tickets to store the tickets info in it
    public Ticket[] tickets = new Ticket[100];

    // method to add flight into array flights
    public void addFlight(Flight flight){
        flights[count] = flight;
        count++;
    }    
    // method to check if flight exist and return the flight that was searched for
    public Flight findFlight(String flightNUM){
        for(int i =0;i<count;i++){
            // check if flight exist by checking if the flight num equals flight num of one of the flights in the array
            if(flightNUM.equals(flights[i].getflightNum())){
                return flights[i];
            }
        }
        // return null if doesnt exist
        return null;
    }   
    // boolean method to check if flight exists and return true or return flase if its not
    public boolean flightExists(String flightNUM){  
        for(int i =0;i<count;i++){
            // check if flight exist by checking if the flight num equals flight num of one of the flights in the array
            if(flightNUM.equals(flights[i].getflightNum()))
                return true;
        }
        return false;
    }  
    // method type ticket it search for the ticket through its name and flight num
    public Ticket findTicket(String name,String flightNum){
        for(int i=0; i<count1;i++){
            // check if ticket in the array and return the ticket if found any ticket with the same name and same flight num
            if (tickets[i].getName().equals(name) && tickets[i].getFlightNum().equals(flightNum))
              return tickets[i];  
        }
        return null;
    }
    // boolean method to check if flight num same as ticket flight num
    public boolean isTicket(Ticket ticket,String flightNum ){
        if(ticket.getFlightNum().equals(flightNum))
            return true;
        return false;
    }
    // return the index of ticket
    public int indexOfTicket(String name,String flightNum){
        for(int i=0; i<count1;i++){
            if(name.equals(tickets[i].getName()) && flightNum.equals(tickets[i].getFlightNum()))
                return i;
        }
        return -1;
    }
    // return the index of the flight
    public int indexOfFlight(String name){
        for(int i=0; i<count;i++){
            if(name.equals(flights[i].getflightNum()))
                return i;
        }
        return -1;
    }
    // add the ticket to array of tickets
    public void addTicket(Ticket ticket){
        tickets[count1] = ticket;
        count1++;
    }
    // method to remove any ticket throug its index
    public void removTicket(int indexToRemove){
        tickets[indexToRemove] = tickets[count1];
        count1--;
    }
    // method to cancel ticket through its name and num
    public void cancelTicket(String flightNum, String name){
        // store index of the ticket in integer it return -1 if ticket not found
        int i = indexOfTicket(name, flightNum);
        if(i == -1)
            System.out.println("No such ticket");
        // if ticket found it remove it from the array through its index
        else {
            tickets[i].cancel();
            count1--;
            // put the ticket we want to remove in the last index in the tickets reached
            tickets[i] = tickets[count1];
            // 
            tickets[count1] = null;

        }
    }    
    // method to print booked passengers it takes the flight num as parmeter and comper it with flight num of any flight in the array and if found one it checks flight num with tickets flight num and if found print the name of ticket
    public void printBookedPassengers(String flightNum){ 
        for(int i =0;i<count;i++){
            if(flightNum.equals(flights[i].getflightNum())){
                System.out.println("Booked Passengers for Flight "+flightNum+":");
                for(int j=0;j<count1;j++)
                    if(flightNum.equals(tickets[j].getFlightNum()))
                        System.out.println("Passenger Name: "+tickets[j]);
            }
            else
                System.out.println("Error: no flight at this number.");
            
        }
    }
    // method to print all availlable flights simply the method checks if the flight still have tickets if yes it print its info
    public void printAvailableFlights(){
        if(count <=0)
            System.out.println("Error: theres no flights.");

        else{
            System.out.println("Available Flights:");
            for(int i=0;i<count;i++){
                if(flights[i].hasTickets()){
                    System.out.println(flights[i]);
                    System.out.println("------------------------------");

                }
                else 
                    continue;
            }
        }
    }


}