package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@SpringBootApplication
public class Application implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();

	Logger logger = LoggerFactory.getLogger(Application.class);
	private String serverUrl = "http://localhost:8300/car";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// ADD CARS

		System.out.println("CREATING CARS==============");
		restTemplate.postForLocation(serverUrl, new CarDto("AB1","IS250", "LEXUS", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB2","IS250", "LEXUS", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB3","IS250", "LEXUS", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB4","COROLLA", "TOYOTA", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB5","COROLLA", "TOYOTA", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB6","COROLLA", "TOYOTA", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB7","GLE450", "MERCEDES", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB8","GLE450", "MERCEDES", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB9","GLE450", "MERCEDES", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB10","PATHFINDER", "NISSAN", BigDecimal.valueOf(2500),true));
		restTemplate.postForLocation(serverUrl, new CarDto("AB11","PATHFINDER2", "NISSAN5", BigDecimal.valueOf(7800),true));
		System.out.println("CREATING CARS DONE 10 ==============");


		System.out.println("UPDATING 2 CARS==============");

		restTemplate.put(serverUrl+"/{licensePlate}/update",  new CarDto("AB8","GLE451", "MERCEDES", BigDecimal.valueOf(2500),true),"AB8");
		restTemplate.put(serverUrl+"/{licensePlate}/update",new CarDto("AB9","GLE453", "MERCEDES", BigDecimal.valueOf(2500),true),"AB9");

		System.out.println("UPDATING 2 CARS DONE==============");

	}
}
