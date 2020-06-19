package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.MedicineEntity;
import app.service.MedicineService;

@RestController
@RequestMapping("med")
public class MedicineEntityController {
	
	@Autowired MedicineService mservice;

	@PostMapping("add")
	public MedicineEntity addMedicine(@RequestBody MedicineEntity m) {
		return mservice.addMedicine(m);
	}
	
	@GetMapping("getAll")
	public List<MedicineEntity> getAllMedicines() {
		return mservice.getAll();
	}
	
	@GetMapping("getById/{id}")
	public MedicineEntity getById(@PathVariable String id) {
		return mservice.getById(id).get();
	}
}
