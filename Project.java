import java.util.Scanner;
import java.util.Date;

public class Project{
    
    public static void main(String[] args) {
        System.out.println("Flight Ticket Booking System");
        //System.out.println();
        //System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
        int choice=0;
        Scanner input = new Scanner(System.in);

        FlightBookingSystem boksystem = new FlightBookingSystem();
        
        System.out.println();
        while(choice != 7){
        FlightBookingSystem.Menu();
	    System.out.print("Enter your choice: ");	
            choice = input.nextInt();    
            System.out.println();

            if(choice == 1){
                Flight flight = readFlight();
                if(boksystem.flightExists(flight.getflightNum()) == false)
                    boksystem.addFlight(flight);
                else 
                    System.out.println("Error: theres a flight at this number.");
            }
            else if (choice ==2){
                Ticket ticket = bookFlight(boksystem);
                    boksystem.addTicket(ticket);
                
                
            }
            else if (choice == 3){
                
                 UpdateFlight(boksystem);
                // boksystem.addTicket(ticket);
            }
            else if (choice == 4){
                cancelTicket(boksystem);
                // int indexToRemove = boksystem.indexOfName(null);

            }
            else if (choice == 5){
                System.out.print("Enter the flight number to view booked passengers: " );
                String NumOfFLIGHT = input.next();
                boksystem.PrintBookedPassengers(NumOfFLIGHT);
                // PrintBookedPassengers();
            }
            else if (choice == 6){
                boksystem.printAvailableFlights();
	        }
            else if (choice == 7){
                System.out.println("Thank you for using the Flight Ticket Booking System. Goodbye!");
                break;
            }
            else{
                System.out.println("no such operation! Please try again.\n");                
		continue;
            }
        }
    }   
    public static Flight readFlight(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        String flightNUM = sc.nextLine();
        System.out.print("Enter origin airport: ");
        String destination = sc.nextLine();
        System.out.print("Enter destination airport: ");
        String OriginAirport = sc.nextLine();
        System.out.print("Enter departure date: ");
        String departureDate = sc.nextLine();
        System.out.print("Enter departure time: ");
        String departureTime = sc.nextLine();
        System.out.print("Enter total number of tickets: ");
        int numOfTickets = sc.nextInt();
        System.out.print("Enter ticket price: ");
        int ticketPrice = sc.nextInt();
        System.out.print("Flight added successfully!");
        
        System.out.println();
        return new Flight(flightNUM, destination, OriginAirport, departureDate, departureTime, numOfTickets, ticketPrice);
    }

    
    public static void UpdateFlight(FlightBookingSystem bokSystem){
        Scanner scanForUpdate = new Scanner(System.in);

        System.out.println("Enter the flight number to update ticket: ");
        String flightNum = scanForUpdate.next();
        if(bokSystem.flightExists(flightNum)){
            System.out.println("Enter passenger name to update ticket: ");
            String name = scanForUpdate.next();
            Ticket ticket = bokSystem.findTicket(name,flightNum);
            if(ticket != null ){
                System.out.println("Enter new passenger name: ");
                String newName = scanForUpdate.next();
                // int ind = bokSystem.indexOfName(name);
                ticket.setName(newName);
            }
            else
                System.out.println("Error: no ticket at this name.");
        }
        else{
            System.out.println("Error: theres no flight at this num.");
        }
    }
    public static Ticket bookFlight(FlightBookingSystem bokSystem){
        Scanner Book = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the flight number to book tickets: ");
        String Num = Book.nextLine();
        if(bokSystem.flightExist(Num)!=null){
            Flight flight = bokSystem.flightExist(Num);
            if(flight.hasTickets() == true){
                System.out.print("Enter passnger name: ");
                String name = Book.nextLine();
                System.out.println("Ticket booked for flight "+Num+" for passnger "+ name);
                return flight.bookTicket(name);
            }
            else {
                System.out.print("Error: no tickets avilable. ");
                return null;
            }
        }
        else{
            System.out.println("Error: wrong flight number.");

            return null;}        
    }
    public static void cancelTicket(FlightBookingSystem bokSystem){
        Scanner scanForRemove = new Scanner(System.in);
        System.out.println("Enter the flight number to remove ticket: ");
        String flightNum = scanForRemove.next();
        if(bokSystem.flightExist(flightNum) != null){
            System.out.println("Enter passenger name to remove ticket: ");
            String newName = scanForRemove.next();
            bokSystem.cancelTicket(flightNum, newName);
        }
        else{
            System.out.println("Error: there no flight at this number.");
        }
    }
    
  

}