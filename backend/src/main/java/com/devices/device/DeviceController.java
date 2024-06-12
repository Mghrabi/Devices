package com.devices.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class DeviceController {

	public final DeviceService deviceService; 

	@Autowired
	public DeviceController(DeviceService deviceService){
		this.deviceService = deviceService;
	}

	@GetMapping("/devices")
	public List<Device> getDevices() {
		return deviceService.getDevices();
	}

	@GetMapping("/devices/{id}")
	public Optional<Device> getDeviceById(@PathVariable Long id) {
		return deviceService.getDeviceById(id);
	}

	@PostMapping("/devices")
	public Device addDevice(@RequestBody Device device) throws Exception {
		// System.out.println(device);
		return deviceService.addDevice(device);
	}	

	@PostMapping("/predict/{id}")
	public Device predictPrice(@PathVariable Long id) throws Exception {
		return deviceService.predictPrice(id);
	}	
}
