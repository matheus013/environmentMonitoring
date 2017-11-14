package laccan.memory.data.reduction;

import laccan.devices.MicazMsg;
import laccan.memory.Container;

import java.util.ArrayList;

public class AllaReduction extends Container {
    private int capacity;

    public AllaReduction(int capacity) {
        super();
        this.capacity = capacity;
        content = new ArrayList<>();
    }

    @Override
    public void add(MicazMsg msg) {

    }

}
