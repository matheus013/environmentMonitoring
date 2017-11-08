package data;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class DataGrid {
    protected double[][] predict;
    protected double[][] collected;

    public DataGrid() {
        predict = new double[100][100];
        collected = new double[100][100];
    }

    public void collectedToFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("collected.csv", "UTF-8");
        int line = 0;
        for (int i = 1; i <= 100; i++)
            for (int j = 1; j <= 100; j++) {
                if (collected[i - 1][j - 1] != 0.0)
                    writer.println(++line + "," + i + "," + j + "," + collected[i - 1][j - 1]);
            }
        writer.close();
    }

    public void loadDataCloud(){
        //read data from sensor
    }

    public void updatePredictCloud(){
        //write prediction from tensorflow
    }
}
