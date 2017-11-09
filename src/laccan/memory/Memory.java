package laccan.memory;

import laccan.devices.MicazMsg;
import laccan.memory.data.reduction.AllaReduction;
import laccan.memory.data.reduction.KeepingAll;
import laccan.memory.data.reduction.RandomReduction;

public class Memory {
    private static KeepingAll keepingAll;
    private static Container dataContainer;
    private static int capacity;

    static public KeepingAll fullGet() {
        if (keepingAll == null) {
            keepingAll = new KeepingAll();
        }
        return keepingAll;
    }

    static public void buildRandomReduction() {
        dataContainer = new RandomReduction(capacity);
    }

    static public void buildAllaReduction() { dataContainer = new AllaReduction(capacity);  }

    static public Container getMemory() {
        return dataContainer;
    }

    static public void setCapacity(int capacity) {
        Memory.capacity = capacity;
    }

    static public void add(MicazMsg msg) {
        fullGet().add(msg);
        getMemory().add(msg);
    }

}
