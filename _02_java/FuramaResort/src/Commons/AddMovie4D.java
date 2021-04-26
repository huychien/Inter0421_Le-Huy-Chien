package Commons;

import Libs.NameException;

import java.util.Scanner;

public class AddMovie4D {
    public static String writeMovieName() {
        System.out.println("Enter customer name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }
}
