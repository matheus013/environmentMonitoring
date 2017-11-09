package laccan.memory.data.reduction;

import laccan.devices.MicazMsg;
import laccan.memory.Container;

public class KeepingAll extends Container{

	@Override
	public void add(MicazMsg msg) {
		// TODO Auto-generated method stub
		content.add(msg);
		
	}

}
