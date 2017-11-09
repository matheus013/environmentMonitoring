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
import java.util.Map;

public class DataGrid {
    JCL_facade jcl;
    protected HashMap<Point, MicazMsg> predictSample;
    protected HashMap<Point, MicazMsg> realSample;

    public DataGrid() {
        predictSample = new HashMap<>();
        realSample = new HashMap<>();
        jcl = JCL_FacadeImpl.getInstance();
    }

    public void realToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("realSample.csv", "UTF-8");
        int line = 0;
        for (Map.Entry<Point, MicazMsg> msg : realSample) {
            writer.println(++line + "," + msg.getKey().x + "," + msg.getKey().y + ","
                    + msg.getValue().getElement_Intersema_data(0) / 10);
        }
        writer.close();
    }

    public void loadDataCloud() {
        //read data from sensor
        JCL_result result = jcl.getValue("dataCollected");
        realSample = (HashMap<Point, MicazMsg>) result.getCorrectResult();

    }

    public void updatePredictCloud() {
        //write prediction from tensorflow
        if (!jcl.containsGlobalVar("dataPredict"))
            jcl.instantiateGlobalVar("dataPredict", predictSample);
        else jcl.setValueUnlocking("dataPredict", predictSample);
    }
}
