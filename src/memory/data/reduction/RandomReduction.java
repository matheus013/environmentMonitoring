package memory.data.reduction;

import laccan.devices.MicazMsg;
import memory.Container;

import java.util.Random;

public class RandomReduction extends Container {
	private int capacity;

	public RandomReduction(int capacity) {
		super();
		this.capacity = capacity;
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
