package src;

/**
 * @author  T_Tin on 9/16/2018.
 * Class using pi calculate
 */
public class PiWork extends Thread {
    private TaskProvider provider;
    private double result;
    private static boolean keepRunning = true;

    public PiWork(TaskProvider provider){
        this.provider = provider;
    }

    public static void stopProgram(){
        keepRunning = false;
    }
    public void run() {
        while (provider.hasTask() && keepRunning){
            Task t = provider.next();
            for(double i = t.getHead(); i < t.getTail(); i++) {
                result += Math.pow(-1, i) / ((2 * i) + 1);
            }
        }
    }
    public double getResult(){
        return result;
    }
}
