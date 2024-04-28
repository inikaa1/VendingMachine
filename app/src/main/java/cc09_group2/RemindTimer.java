package cc09_group2;

import java.util.Timer;
import java.util.TimerTask;

public class RemindTimer {
    Timer timer;
    public RemindTimer(int seconds){
        timer = new Timer();
        timer.schedule(new remindTask(),seconds*1000);
    }
    class remindTask extends TimerTask{
        public void run(){
            System.out.println("\n__________________________________________________________________________\n");
            System.out.println("\nTime's up!\n");
            System.out.println("....Logging out of vending machine");
            System.out.println("\n__________________________________________________________________________\n");

            timer.cancel();
            //TODO add cancel transaction function here
            // NOTE cancellation reason: "timeout"

            // TODO edit following line if timeout goes to product page instead
            //App.main(null);
        }
    }

    
}
