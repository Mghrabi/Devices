package com.devices.device;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	public Optional<Device> getDeviceById(Long id) {
		return deviceRepository.findById(id);
	}

	public Device addDevice(Device device) throws Exception {
		try {
			deviceRepository.save(device);
			return device;
		} catch (Exception e) {
			throw new Exception("Device can't be added");
		}
	}

	public Device predictPrice(Long id) throws Exception {
		try {
			System.out.println("got here1");
			Optional<Device> optionalDevice = getDeviceById(id);
			if (optionalDevice.isPresent()) {
				Device device = optionalDevice.get();
				System.out.println("got here2");
				System.out.println(device);
				// Assuming your Python API endpoint is at http://localhost:5000/predict
				String url = "http://localhost:5000/predict";

				// Create a RestTemplate instance
				RestTemplate restTemplate = new RestTemplate();

				// Send a POST request with the device object as the request body
			ResponseEntity<String> response = restTemplate.postForEntity(url, device, String.class);

            // Parse the JSON response to get the price range
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            int price_range = jsonNode.get("price_range").asInt();

            // System.out.println("Predicted price range: " + price_range);
			device.setPriceRange(price_range);
			deviceRepository.save(device);
			return device;
			} else {
				throw new Exception("Device not found!");
			}
		} catch (Exception e) {
			throw new Exception("Error predicting price: " + e.getMessage());
		}
	}
}

// System.out.println(device);
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