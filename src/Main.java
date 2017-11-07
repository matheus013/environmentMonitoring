import utils.ScriptRun;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        ScriptRun sr = new ScriptRun("$PWD/src/script.py", "");
        sr.run();
    }
}