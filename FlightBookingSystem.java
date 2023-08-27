public class FlightBookingSystem{
    private int count=0;
    public Flight[] flights = new Flight[100];
    public Ticket[] tickets = new Ticket[100];
    public void addFlight(Flight flight){
        flights[count] = flight;
        count++;
    }


    public static void Menu(){
        System.out.println();
        System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
    }
    
    public void printAll(Flight flight,Ticket ticket){
        System.out.println(flight,ticket);
    }
}