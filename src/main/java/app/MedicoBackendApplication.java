package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.service.MedicineService;

@SpringBootApplication
public class MedicoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicoBackendApplication.class, args);
		MedicineService mservice = new MedicineService();
		mservice.getMedicine();
	}

}
