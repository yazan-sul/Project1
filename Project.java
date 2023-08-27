import java.util.Scanner;
import java.util.Date;

public class Project{
    
    public static void main(String[] args) {
        System.out.println("Flight Ticket Booking System");
        System.out.println();
        System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
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
                boksystem.addFlight(flight);
            }
            else if (choice ==2){
                boksystem.printAvailableFlights();

               // BookFlight();

            }
            else if (choice == 3){
               // UpdateFlight();

            }
            else if (choice == 4){
                // RemoveFlight();
            }
            else if (choice == 5){
                // PrintBookedPassengers();

            }
            else if (choice == 6){
                
            
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
    public static void UpdateFlight(){
        System.out.println("== Update Ticket ==\nDummy method to update a ticket.");
        System.out.println();


    }
    
    /*public void BookFlight(){
        Scanner Book = new Scanner(System.in);
        System.out.println();
        int flag = 0;
        System.out.println("Enter the flight number to book tickets: ");
        String Num = Book.nextLine();
        if(){

        }
        System.out.println();
        
    }
    */
    /* 
    public static void RemoveFlight(){
        Scanner remov = new Scanner(System.in);
        System.out.print("Enter the flight number to remove tickets: ");
        String Num = remov.nextLine();
        int flag =0, flag2=0,reminder=0;
        for(int i = 0;i<index;i++){
            if(Num.equals(flightNum[i])){
                flag=1;
                break;
            }
        }
        if(flag ==1){
            System.out.print("Enter passenger name to remove: ");
            String pas = remov.nextLine();
            for(int i = 0;i<pos;i++){
                if(pas.equals(name[i])){
                    flag2=1;
                    reminder = i;
                    break;
                }
            }
            if(flag2 == 1){
                for(int i = reminder;i<pos;i++){
                    for(int j=reminder+1;j<pos;j++){
                        String temp = name[i];
                        name[i] = name[j];
                        name[j] = temp;
                    }
                }
                System.out.println("removed");
                pos--;
            }
        }
        else    
            System.out.println("theres no flight at this num.");
        System.out.println();
    
    }
    public static void DisplayAvailableFlights(){
        System.out.println("== Display Available Flights ==\nDummy method to display available flights.");
        System.out.println();

    }
    public static void PrintBookedPassengers(){
        Scanner bookPass = new Scanner(System.in);
        System.out.print("Enter the flight number to view booked passengers: ");
        String Num = bookPass.nextLine();

        System.out.println();

    }
    


   
    }*/   
}