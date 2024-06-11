package com.devices.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
@RequestMapping(path = "/api/devices")
public class DeviceController {

	public final DeviceService deviceService; 

	@Autowired
	public DeviceController(DeviceService deviceService){
		this.deviceService = deviceService;
	}

	@GetMapping
	public List<Device> getDevices() {
		return deviceService.getDevices();
	}

	@PostMapping
	public void addDevice(Device device) {
		deviceService.addDevice(device);
	}	
}
