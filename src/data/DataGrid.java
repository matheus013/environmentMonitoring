package data;

public class DataGrid {
    protected double[][] predict;
    protected double[][] collected;

    public DataGrid() {
        predict = new double[100][100];
        collected = new double[100][100];
    }
}
