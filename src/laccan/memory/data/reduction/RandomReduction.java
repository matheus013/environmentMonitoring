package laccan.memory.data.reduction;

import laccan.devices.MicazMsg;
import laccan.memory.Container;

import java.util.ArrayList;
import java.util.Random;

public class RandomReduction extends Container {
    private int capacity;

    public RandomReduction(int capacity) {
        super();
        this.capacity = capacity;
        this.content = new ArrayList<>();
    }

    @Override
    public void add(MicazMsg msg) {
        // TODO Auto-generated method stub
        if (length() < capacity) {
            content.add(msg);
        } else {
            Random rand = new Random();
            content.set(rand.nextInt(capacity), msg);
        }

    }

}
