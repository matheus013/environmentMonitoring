package memory;

import laccan.devices.MicazMsg;
import memory.data.reduction.KeepingAll;
import memory.data.reduction.RandomReduction;

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

    public void buildRandomReduction() {
        dataContainer = new RandomReduction(1000);
    }

    public void buildAllaReduction() {
        dataContainer = new AllaReduction(1000);
    }

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
