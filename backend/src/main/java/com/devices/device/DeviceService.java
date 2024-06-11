package com.devices.device;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
	public List<Device> getDevices() {
		return List.of(new Device(1872, true, 2.9f, false, 0, 0.0f, 1.0f, 3.0f, 0.9f, 105.0f, 426.0f, 1629.0f, 1308.0f,
				5.0f, 0.0f, 2, true, false, true, 1));
	}
}
