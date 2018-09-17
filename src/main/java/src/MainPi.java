package src;

import java.util.Scanner;

/**
 * @author: T_Tin on 9/14/2018.
 * @param: Calculate an approximation to Pi
 */

public abstract class MainPi {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int n = 0;
        System.out.println("Input integer:(press x to stop)");
        System.out.println("Input n:");
        n = Integer.parseInt(scanner.nextLine());
        PiWork pw = new PiWork();
        pw.calculatePi(n);
    }
}

