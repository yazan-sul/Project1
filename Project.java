import java.util.Scanner;
import java.util.Date;
public class Project{
    static int Size = 100;
    static int index = 0;
    static int pos = 0;

    static String flightNum[] = new String[Size];
    static String destination[] = new String[Size];
    static String OriginAirport[] = new String[Size];
    static String []departureDate = new String[Size];
    static String []departureTime = new String[Size];
    static String []name = new String[Size];

    static int []numOfTickets = new int[Size];
    static int []ticketPrice = new int[Size];
    
    public static void main(String[] args) {
        System.out.println("Flight Ticket Booking System");
        System.out.println();
        System.out.println("1. Add New Flight\n"+ "2. Book Ticket\n"+ "3. Update Ticket\n"+ "4. Remove Ticket\n" + "5. Print Booked Passengers\n"+ "6. Display Available Flights\n" +"7. Exit");
        int choice=0;
        Scanner input = new Scanner(System.in);
        System.out.println();
        while(choice != 7){
	    System.out.print("Enter your choice: ");	
            choice = input.nextInt();    
            System.out.println();


            if(choice == 1){
                AddFlight();
                Size++;
 		Menu();
            }
            else if (choice ==2){
                BookFlight();
 		Menu();

            }
            else if (choice == 3){
                UpdateFlight();
 		Menu();

            }
            else if (choice == 4){
                RemoveFlight();
 		Menu();
            }
            else if (choice == 5){
                PrintBookedPassengers();
 		Menu();

            }
            else if (choice == 6){
                printall(flightNum, destination, departureTime, departureDate, OriginAirport, numOfTickets, numOfTickets);
                
 		Menu();
            
	    }
            else if (choice == 7){
                System.out.println("Thank you for using the Flight Ticket Booking System. Goodbye!");
                break;
            }
            else{
                System.out.println("no such operation! Please try again.\n");                
                Menu();
		continue;
            }
        }
    }   
    public static void AddFlight(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        flightNum[index] = sc.nextLine();
        System.out.print("Enter origin airport: ");
        destination[index] = sc.nextLine();
        System.out.print("Enter destination airport: ");
        OriginAirport[index] = sc.nextLine();
        System.out.print("Enter departure date: ");
        departureDate[index] = sc.nextLine();
        System.out.print("Enter departure time: ");
        departureTime[index] = sc.nextLine();
        System.out.print("Enter total number of tickets: ");
        numOfTickets[index] = sc.nextInt();
        System.out.print("Enter ticket price: ");
        ticketPrice[index] = sc.nextInt();
        System.out.print("Flight added successfully!");
        index++;
        System.out.println();
    }
    public static void UpdateFlight(){
        System.out.println("== Update Ticket ==\nDummy method to update a ticket.");
        System.out.println();


    }
    public static void BookFlight(){
        Scanner Book = new Scanner(System.in);
        System.out.println(index);
        int flag = 0;
        for(int i = 0;i<index;i++){
            
            System.out.println(flightNum[i]);
        }
        
        System.out.println("Enter the flight number to book tickets: ");
        String Num = Book.nextLine();
        for(int i = 0;i<index;i++){
            if(Num.equals(flightNum[i])){
                flag=1;
                break;
            }
        }
        if(flag == 1){
            System.out.println("enter passenger name: ");
            name[pos] = Book.nextLine();
            System.out.printf("Ticket booked for Flight %s for passenger %s ",Num,name[pos]);
            pos++;   
        }
        else{
            flag = 0;
            System.out.println("Theres no flight at this number.");
        }
        System.out.println();
        
    }
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
    


    public static void printall(String []b ,String []d ,String []c ,String []a ,String []j ,int[]o,int[]m){
        for(int i = 0; i<index;i++){
            System.out.print(b[i] +" "+ d[i]+" "+c[i] +""+ a[i] + " "+j[i]+" "+o[i]+" "+ m[i]+"  "+"\n");
        }
    }   
}