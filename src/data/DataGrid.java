package data;

import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;
import interfaces.kernel.JCL_result;
import laccan.devices.MicazMsg;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class DataGrid {
    JCL_facade jcl;
    protected HashMap<Point, MicazMsg> predict;
    protected HashMap<Point, MicazMsg> collected;

    public DataGrid() {
        predict = new HashMap<>();
        collected = new HashMap<>();
        jcl = JCL_FacadeImpl.getInstance();
    }

    public void collectedToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("collected.csv", "UTF-8");
        int line = 0;
        for (MicazMsg msg : collected) {

        }
        writer.close();
    }

    public void loadDataCloud() {
        //read data from sensor
        JCL_result result = jcl.getValue("dataCollected");
        collected = (HashMap<Point, MicazMsg>) result.getCorrectResult();

    }

    public void updatePredictCloud() {
        //write prediction from tensorflow
        if (!jcl.containsGlobalVar("dataPredict"))
            jcl.instantiateGlobalVar("dataPredict", predict);
        else jcl.setValueUnlocking("dataPredict", predict);
    }
}
