import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        JCL_facade jcl = JCL_FacadeImpl.getInstance();
        //creating a simple variable
        System.err.println(jcl.instantiateGlobalVar("firstVar", new String("nada")));
        jcl.setValueUnlocking("firstVar", "hello world");
    }

}