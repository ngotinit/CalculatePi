package src;

/**
 * @author T_Tin on 9/16/2018.
 */
public class TaskProvider extends GetCore {

    private static int valuePerTask = 1000 ;
    private static  int maxThread = GetCore.getCoreCPU();
    public static int head = 0;
    public static int tail = valuePerTask;


    public static int calculteNumberLoad (int n) {
        int numberLoad = n / (maxThread * valuePerTask);
        return numberLoad;
    }

    public static int calculateOverBalance (int n, int numberLoad){
        int modOfn =  n - numberLoad * (maxThread * valuePerTask);
        return modOfn;
    }

    public static int nextHead(){
        head = tail;
        return head;
    }

    public static int nextTail(){
        tail =  tail + valuePerTask;
        return tail;
    }

}
