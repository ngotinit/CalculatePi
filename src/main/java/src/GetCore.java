package src;

/**
 * @author T_Tin on 9/16/2018.
 */

public class GetCore {
    public static int getCoreCPU(){
        int cores = Runtime.getRuntime().availableProcessors();
        return 2*cores;
    }
}
