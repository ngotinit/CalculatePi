package src;

import java.util.Scanner;

/**
 * @author: T_Tin on 9/14/2018.
 * @param: Calculate an approximation to Pi
 */

public abstract class MainPi{

    private static Scanner scanner = new Scanner(System.in);
    private static double n;
    private static double finalresult;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Input integer:(press x to stop)");
        System.out.println("Input n:");
        n = Double.parseDouble(scanner.nextLine());
        TaskProvider provider = new TaskProvider();
        provider.setInput(n);

        Thread t = new Thread(){
            public void run(){
                while(scanner.next().equals("x")){
                    PiWork.stopProgram();
                }
            }
        };
        t.start();

        Thread[] arrayworker= new Thread[GetCore.getCoreCPU()];
        for(int i = 0; i< GetCore.getCoreCPU(); i++) {
            arrayworker[i] = new PiWork(provider);
            arrayworker[i].start();
        }
        for(int i = 0; i< GetCore.getCoreCPU(); i++){
            arrayworker[i].join();
        }
        for(int i = 0; i< GetCore.getCoreCPU(); i++){
            PiWork p = (PiWork) arrayworker[i];
            finalresult += p.getResult();
        }

        System.out.println("Final result: " +  4*finalresult);
    }
}

