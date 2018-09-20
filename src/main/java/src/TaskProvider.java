package src;

/**
 * @author T_Tin on 9/16/2018.
 * @param
 */
public class TaskProvider{
    private double numberinput;
    private double start = 0;
    private double valuepertask = 10000;
    private double end = 0;

    public double setInput(double n){
        this.numberinput = n;
        return numberinput;
    }

    public boolean hasTask(){
        if(this.end < numberinput){
            return true;
        }else{
            return false;
        }
    }

    synchronized Task next(){
        if((end + valuepertask) < numberinput) {
            start = end;
            end = end + valuepertask;
            return new Task(start,end);
        }else{
            start = end;
            end = numberinput;
            return new Task(start, numberinput);
        }

    }
}
