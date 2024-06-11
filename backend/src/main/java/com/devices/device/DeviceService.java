package com.devices.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
	private final DeviceRepository deviceRepository;

	@Autowired
	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<Device> getDevices() {
		return deviceRepository.findAll();
	}

	public void addDevice(Device device) {
		System.out.println(device);
		// Device d = new Device(
		// 2000,
		// true,
		// 2.0f,
		// true,
		// 8,
		// 1.0f,
		// 16.0f,
		// 0.8f,
		// 150.0f,
		// 8.0f,
		// 12,
		// 800.0f,
		// 1280.0f,
		// 2.0f,
		// 5.5f,
		// 3.0f,
		// 10,
		// true,
		// true,
		// true,
		// 3
		// );
		// return d;
	}
}
