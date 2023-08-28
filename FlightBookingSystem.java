import java.util.Scanner;

public class FlightBookingSystem{
    private int count=0,count1;
    public Flight[] flights = new Flight[100];
    public Ticket[] tickets = new Ticket[100];

    public void addFlight(Flight flight){
        flights[count] = flight;
        count++;
    }

    
    public Flight flightExist(String flightNUM){
        for(int i =0;i<count;i++){
            if(flightNUM.equals(flights[i].getflightNum())){
                return flights[i];
            }
        }
        return null;
    }   

    public boolean flightExists(String flightNUM){
        for(int i =0;i<count;i++){
            if(flightNUM.equals(flights[i].getflightNum()))

                return true;
        }
        return false;
    }  

    public Ticket findTicket(String name,String flightNum){
        for(int i=0; i<count1;i++){
            if (tickets[i].getName().equals(name) && tickets[i].getFlightNum().equals(flightNum))
              return tickets[i];  
        }
        return null;
    }

    public boolean isTicket(Ticket ticket,String flightNum ){
        if(ticket.getFlightNum().equals(flightNum))
            return true;
        return false;
    }

    public int indexOfName(String name){
        for(int i=0; i<count1;i++){
            if(name.equals(tickets[i].getName()))
                return i;
        }
        return -1;
    }
    public int indexOfFlight(String name){
        for(int i=0; i<count;i++){
            if(name.equals(flights[i].getflightNum()))
                return i;
        }
        return -1;
    }

    public void addTicket(Ticket ticket){
        tickets[count1] = ticket;
        count1++;
    }

    public void removTicket(Ticket ticket){
        tickets[count1] = ticket;
        count1--;
    }

    public static void Menu(){
        System.out.println();
        System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
    }
    
    public static void printAll(Flight flight){
            System.out.println(flight);
    }

    public void PrintBookedPassengers(String flightNum){ 
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