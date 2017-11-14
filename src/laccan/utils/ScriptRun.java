package laccan.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScriptRun {

    private String data;
    private String script;

    public ScriptRun(String script, String data) {
        this.data = data;
        this.script = script;
    }

    public void run() throws IOException {
        String s = null;
        File file = new File(data);
        if (file.exists()) {
            Process p = Runtime.getRuntime().exec("python " + script + " " + data);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            while ((s = stdInput.readLine()) != null) {
                System.out.println("Here is the standard output of the command:\n");
                System.out.println(s);
            }

            while ((s = stdError.readLine()) != null) {
                System.out.println("Here is the standard error of the command (if any):\n");
                System.out.println(s);
            }
        }
    }
}
