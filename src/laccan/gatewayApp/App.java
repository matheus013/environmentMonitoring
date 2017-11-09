/**
 * @author <Geymerson Ramos>
 * @email: <geymerson@laccan.ufal.com>
 * Universidade Federal de Alagoas - UFAL
 * Laboratório de Computação Científica e Análise Numérica - LACCAN
 * <p>
 * last update at August 19, 2017
 **/

package laccan.gatewayApp;

import data.DataGrid;
import laccan.devices.Micaz;
import utils.ScriptRun;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) {
        DataGrid dataGrid = new DataGrid();
        @SuppressWarnings("unused")
        Timer timer = new Timer();
        TimerTask updateDataPredict = new TimerTask() {
            @Override
            public void run() {
                try {
                    dataGrid.realToFile();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ScriptRun sr = new ScriptRun(
                        "/script/predict.py",
                        "/script/data.csv");
                try {
                    sr.run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        TimerTask updateDataSample = new TimerTask() {
            @Override
            public void run() {
                dataGrid.updatePredictCloud();
            }
        };
        // update global var predicts, interval 5 min
        timer.schedule(updateDataPredict, 0, 300000);
        // refresh global var in caela
        // pass data from the sensors to caela, interval 1 min
        timer.schedule(updateDataSample, 0, 60000);
        Micaz micaz = new Micaz("serial@/dev/ttyUSB1:57600");
    }
}
