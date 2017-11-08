import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        int [][] x = new int[10][10];

        x[0][0] = 100;
        x[2][1] = 3123;
        System.out.printf(String.valueOf(x[2][1]));
    }

}