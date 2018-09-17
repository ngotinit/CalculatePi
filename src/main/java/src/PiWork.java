package src;

import java.util.Scanner;

/**
 * @author  T_Tin on 9/16/2018.
 * Class using pi calculate
 */
public class PiWork extends TaskProvider implements Runnable {
    private int start;
    private int end;
    private double result;
    private boolean run = true;
    public double resultCurent;
    public static Scanner in = new Scanner(System.in);

    public void getStartEnd(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            result += Math.pow(-1, i) / ((2 * i) + 1);
        }
        System.out.println("from ---" + start);
        System.out.println(Thread.currentThread().getName() + " result =" + result);
        System.out.println("to ---" + end);
    }

    public double getResultPerTask(){
        return result;
    }

    public double calculatePi(int n) throws InterruptedException {
        if(calculateOverBalance(n,calculteNumberLoad(n)) == 0){
            for(int i = 0; i < calculteNumberLoad(n); i++) {
                for(int j = 0; j < getCoreCPU(); j++) {
                    System.out.println(getCoreCPU());
                    PiWork piwork = new PiWork();
                    piwork.getStartEnd(head, tail);
                    Thread t = new Thread(piwork);
                    t.setName("Thread -" + j);
                    t.start();
                    t.join();
                    nextHead();
                    nextTail();
                    resultCurent += piwork.getResultPerTask();
                }
            }
            System.out.println("Final result = " + 4*resultCurent);
        }else if(calculateOverBalance(n,calculteNumberLoad(n)) != 0){
            for(int i = 0; i < calculteNumberLoad(n); i++) {
                for(int j = 0; j < getCoreCPU(); j++) {
                    System.out.println(getCoreCPU());
                    PiWork piwork = new PiWork();
                    piwork.getStartEnd(head, tail);
                    Thread t = new Thread(piwork);
                    t.setName("Thread -" + j);
                    t.start();
                    t.join();
                    nextHead();
                    nextTail();
                    resultCurent += piwork.getResultPerTask();
                }
            }
            for(int i = n - calculateOverBalance(n,calculteNumberLoad(n)); i < n ; i++){
                System.out.println(i);
                resultCurent += Math.pow(-1, i) / ((2 * i) + 1);
                System.out.println(resultCurent);
            }
            System.out.println("Final result = " + 4*resultCurent);
        }
        return 0;
    }



}
