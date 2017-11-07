import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String args[]) throws IOException {
//        ScriptRun sr = new ScriptRun("$PWD/src/script.py", "");
//        sr.run();
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                System.out.printf("hi");
            }
        };

        timer.schedule(myTask, 2000, 2000);
    }

}