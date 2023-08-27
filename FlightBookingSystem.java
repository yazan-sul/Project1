public class FlightBookingSystem{
    private int count=0,count1;
    public Flight[] flights = new Flight[100];
    public Ticket[] tickets = new Ticket[100];

    public void addFlight(Flight flight){
        flights[count] = flight;
        count++;
    }
    
    public void addTicket(Ticket ticket){
        tickets[count1] = ticket;
        count1++;
    }

    public static void Menu(){
        System.out.println();
        System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
    }
    
    public static void printAll(Flight flight){
            System.out.println(flight);
    }

    public void printAvailableFlights(){
        for(int i=0;i<flights.length;i++){
            if(this.hasTickets()){
                System.out.println(flights[i]);
            }
        }
    }
}