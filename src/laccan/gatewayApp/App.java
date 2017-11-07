/**
 * @author <Geymerson Ramos>
 * @email: <geymerson@laccan.ufal.com>
 * Universidade Federal de Alagoas - UFAL
 * Laboratório de Computação Científica e Análise Numérica - LACCAN
 * <p>
 * last update at August 19, 2017
 **/

package laccan.gatewayApp;

import laccan.devices.Micaz;
import utils.ScriptRun;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Timer timer = new Timer();
        TimerTask updateDataPredict = new TimerTask() {
            @Override
            public void run() {
                ScriptRun sr = new ScriptRun(
                        "/home/matheus/IdeaProjects/dtn-cala/script/predict.py",
                        "/home/matheus/IdeaProjects/dtn-cala/script/data.csv");
                try {
                    sr.run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        timer.schedule(updateDataPredict, 0, 300000);
        Micaz micaz = new Micaz("serial@/dev/ttyUSB1:57600");
    }
}
