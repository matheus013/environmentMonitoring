package memory.data.reduction;

import laccan.devices.MicazMsg;
import memory.Container;

public class KeepingAll extends Container{

	@Override
	public void add(MicazMsg msg) {
		// TODO Auto-generated method stub
		content.add(msg);
		
	}

}
