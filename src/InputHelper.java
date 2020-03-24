import java.util.Scanner;

public class InputHelper {
    public static int getIntFromUser(){
        Scanner scanInput = new Scanner(System.in);

        while(!scanInput.hasNextInt()){
            System.out.printf("Dit input er '%s' , det  not a number. Please try again.%n", scanInput.nextLine());
            continue;
        }
        return scanInput.nextInt();
    }

    public static int getOptionFromUser(int minInt, int maxInt){
        Scanner scan = new Scanner(System.in);
        int retNumber;
        boolean isNotValid = false;

        do{
            if(isNotValid){
                System.out.printf("The number must be between %d and %d%n", minInt, maxInt);
            }
            while(!scan.hasNextInt()){
                System.out.printf("That is not a number! Please try again.%n");
                scan.next();
            }
            // hasNextInt() true, reading number from console
            retNumber = scan.nextInt();
            isNotValid = retNumber < minInt || retNumber > maxInt;
        }while(isNotValid);

        return retNumber;
    }

    public static String getStringFromUser(String title){
        Scanner scanInput = new Scanner(System.in);

        System.out.printf("Please enter the " + title + " of the person%n");
        String name = scanInput.next();
        while(name.matches(".*\\d.*")){
            System.out.printf("A " + title + " cannot contain a number! Please try again%n");
            name = scanInput.next();
        }
        return name;
    }
}
