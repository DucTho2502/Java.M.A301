package validate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
	
	public final static String EMAIL_FORMAT = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
	public static Scanner sc = new Scanner(System.in);

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public static int getChoice(String msg, int min, int max) {
        int result = 0;
        String line;
        do {
            System.out.format("%s (from %d to %d): ", msg, min, max);
            line = sc.nextLine();
            try {
                result = Integer.parseInt(line);
                if (result >= min && result <= max) break;
                else System.err.format("<= %d and >= %d!!!\n", max, min);
            } catch (NumberFormatException ex) {
                System.err.print("must be an integer: ");
            }
        } while (true);

        return result;
    }
    
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter Integer: ");
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Number must between [" + min + "; " + max + "].");
            }
        }
    }
    
    
    public static String inputEmail() {
        String email;
        do {
            System.out.print("Enter email: ");
            email = sc.nextLine();
        } while (!isEmail(email));
        return email;
    }

    public static boolean isEmail(String email) {
        return Pattern.compile(EMAIL_FORMAT).matcher(email).matches();
    }
    
    public static String getString(String msg, boolean empty, String pattern) {
        String line;
        if (pattern == "empty") {
            do {
                System.out.format("%s: ", msg);
                line = sc.nextLine();
                if (line.trim().isEmpty() && empty == true) return "Not available";
                if (line.trim().isEmpty() && empty == false) System.err.println("Not Empty");
                if (!line.trim().isEmpty()) return line;
            } while (true);
        } else {
            do {
                System.out.format("%s: ", msg);
                line = sc.nextLine();
                if (line.trim().isEmpty() && empty == true) return "Not available";
                if (line.matches(pattern)) return line;
                else System.err.println("Must Be String");
            } while (true);
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static double checkDouble(String msg) {
    	while (true) {
    	    System.out.print(msg);
    	    try {
    	        double result = Double.parseDouble(sc.nextLine().trim());
    	        return result;
    	    } catch (NumberFormatException ignore) {
    	        System.out.println("Invalid input");
    	    }
    	}
    }
}
