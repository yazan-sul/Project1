import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
// main class
public class Project{
    
    public static void main(String[] args) throws java.util.InputMismatchException,IllegalArgumentException,FileNotFoundException,FlightFullException,NullPointerException{
        System.out.println("Flight Ticket Booking System");
        Scanner input = new Scanner(System.in);
       
        //System.out.println();
        //System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
        int choice=0;

        FlightBookingSystem boksystem = new FlightBookingSystem();
        FlightsFileScanner scanner = new FlightsFileScanner("flights.txt");
        while(scanner.hasNextFlight()){
            Flight flight = scanner.readFlight();
            boksystem.addFlight(flight);
        }
        scanner.close();
        System.out.println();
        try{
        
        // while user dont enter number 7 the program will continuo
        while(choice != 7){
            // showing the menu for the user evrey time the loop repats    
            Menu();
            // tell the user to enter his choice
	        System.out.print("Enter your choice: ");	
            choice = input.nextInt();    
            System.out.println();
            // if choice is 1 it will add a flight
            if(choice == 1){
                Flight flight = readFlight();
                // it checks if the flight num exists in the array if no it will let the user to add new flight at the number
                if(boksystem.flightExists(flight.getflightNum()) == false){
                    boksystem.addFlight(flight);}
                else 
                    // printing an error message if flight number already exist
                    System.out.println("Error: theres a flight at this number.");
            }
            // it allow to book a ticket for any flight avilable
            else if (choice ==2){
                // declearing an object type ticket that book a ticket
                Ticket ticket = bookFlight(boksystem);
                // callin addticket from object giving it a ticket type to add the ticket in the array of tickets
                if(ticket != null)
                    boksystem.addTicket(ticket);
            }
            // it allow to change name to new name
            else if (choice == 3){
                // calling the method updateflight giving it object of FlightBookingSystem class
                updateFlight(boksystem);
            }
            else if (choice == 4){
                // calling the method cancelTicket giving it object of FlightBookingSystem class
                cancelTicket(boksystem);
            }
            else if (choice == 5){
                System.out.print("Enter the flight number to view booked passengers: " );
                // read a flight num from user
                try{
                    String NumOfFLIGHT = input.next();
                    //giving the object the flight num to check and print booked passengers
                    boksystem.printBookedPassengers(NumOfFLIGHT);
                }
                catch(NullPointerException e){
                    System.out.println("no ticket at this name");;
                }

            }
            else if (choice == 6){
                // print available flights that still have tickets
                boksystem.printAvailableFlights();
	        }
            else if (choice == 7){
                boksystem.printInFile();
                System.out.println("Thank you for using the Flight Ticket Booking System. Goodbye!");
                // stop the program and exit
                break;
            }
            else{
                // if user enter number out of list it will print error messege and repeat the loop
                System.out.println("no such operation! Please try again.\n");                
		        continue;
            }
        }
        
    }
        
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch(InputMismatchException Ie){
            System.out.println("invalid input");
        }
        catch(IOException s){
            System.out.println("invalid input");
        }
    }   
 
    
    public static Flight readFlight(){
        // declearing a new scanner 
        Scanner sc = new Scanner(System.in);
        // the following messges to tell the user to enter info and read it into the flight
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
        // return object type flight with the info
        return new Flight(flightNUM, destination, OriginAirport, departureDate, departureTime, numOfTickets, ticketPrice);
    }

    // method to update flight it takes object from type FlightBookingSystem
    public static void updateFlight(FlightBookingSystem bokSystem){
        // declearing a new scanner 
        Scanner scanForUpdate = new Scanner(System.in);
        System.out.println("Enter the flight number to update ticket: ");
        // read flight num from user
        String flightNum = scanForUpdate.next();
        // check if flight num exist and if it exist it will go through update procces
        if(bokSystem.flightExists(flightNum)){
        try{ 

            System.out.println("Enter passenger name to update ticket: ");
            // asks the user to enter the name that he want to change
            String name = scanForUpdate.next();
            // declearing a ticket object that takes name and flight num and search for the ticket if found it return the ticket
            Ticket ticket = bokSystem.findTicket(name,flightNum);
                if(ticket != null ){
                    System.out.println("Enter new passenger name: ");
                    // if ticket found it tell the user to enter the new name
                    String newName = scanForUpdate.next();
                    // change the name in the found ticket
                    System.out.println("Ticket updated for Flight "+ flightNum+" for passenger " + newName);
                    ticket.setName(newName);
                }
            }
            catch(NullPointerException Ne){
                System.out.println("no ticket at this ");
            }  
                
        }
        else{
            // print error if there a flight exist with this num
            System.out.println("Error: theres no flight at this num.");
        }
    }
    //method to book ticket that take object type FlightBookingSystem class
    public static Ticket bookFlight(FlightBookingSystem bokSystem){
        // declearing new scanner
        Scanner Book = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the flight number to book tickets: ");
        // read from user the flight num
        String Num = Book.nextLine();
        // check if flight num exist
        if(bokSystem.findFlight(Num)!=null){
            // declearing object type flight
            Flight flight = bokSystem.findFlight(Num);
            // check if the flight selected have tickets
            try{
                if(flight.hasTickets() == true){
                    // if have tickets it read from user a name to book
                    System.out.print("Enter passnger name: ");
                    String name = Book.nextLine();
                    System.out.println("Ticket booked for flight "+Num+" for passnger "+ name);
                    // return a ticket with name booked in it
                    return flight.bookTicket(name);
                }
            }
            catch(NullPointerException e){
                System.out.print("no tickettt");
                return null;
            }
            // else {
            //     // if flight have no tickets left
            //     System.out.print("Error: no tickets avilable. ");
            //     return null;
            // }
        }
        else{
            // if user enter flight num that dosent exist
            System.out.println("Error: wrong flight number.");
            return null;
        }   
        return null;
    }
    // method to remove a ticket from tickets
    public static void cancelTicket(FlightBookingSystem bokSystem){
        // declearing an object
        Scanner scanForRemove = new Scanner(System.in);
        System.out.println("Enter the flight number to remove ticket: ");
        // read the flight num
        String flightNum = scanForRemove.next();
        // check if flight num exist
        if(bokSystem.findFlight(flightNum) != null){
            try{
                System.out.println("Enter passenger name to remove ticket: ");
                // if flight exist it ask the user to enter a name to remove its ticket
                String name = scanForRemove.next();
                // remove the ticket
                System.out.println("ticket canceld");
                bokSystem.cancelTicket(flightNum, name);
            }
            catch(NullPointerException Ne){
                System.out.println("no ticket");
            }
        }
        
    }
    public static void Menu(){
        System.out.println();
        System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
    }
  
    
    
}