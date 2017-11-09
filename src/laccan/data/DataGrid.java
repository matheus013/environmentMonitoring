package laccan.data;

import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;
import interfaces.kernel.JCL_result;
import laccan.devices.MicazMsg;
import laccan.memory.Memory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class DataGrid {
    JCL_facade jcl;
    protected HashMap<Integer, MicazMsg> predictSample;
    protected HashMap<Integer, MicazMsg> realSample;

    public DataGrid() {
        predictSample = new HashMap<>();
        realSample = new HashMap<>();
        jcl = JCL_FacadeImpl.getInstance();
    }

    public void realToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("realSample.csv", "UTF-8");
        int line = 0;
        for (Integer key : realSample.keySet()) {
            writer.println(++line + "," + key + ","
                    + realSample.get(key).getElement_Intersema_data(0) / 10);
        }
        writer.close();
    }

    public void loadDataCloud() {
        //read laccan.data from sensor
        JCL_result result = jcl.getValue("dataCollected");
        realSample = (HashMap<Integer, MicazMsg>) result.getCorrectResult();

    }

    public void updatePredictCloud() {
        //write prediction from tensorflow
        if (!jcl.containsGlobalVar("dataPredict"))
            jcl.instantiateGlobalVar("dataPredict", predictSample);
        else jcl.setValueUnlocking("dataPredict", predictSample);
    }

    public void refreshRealSample() {
        for (MicazMsg msg : Memory.getMemory().get()) {
            realSample.put(msg.get_nodeid(), msg);
        }
    }
}
