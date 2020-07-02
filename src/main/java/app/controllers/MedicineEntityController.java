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
import org.springframework.web.servlet.function.ServerResponse;

import app.entity.MedicineEntity;
import app.exception.FileNotFoundInDatabase;
import app.model.DummyModel;
import app.model.MedicineModel;
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
	
	@GetMapping("detAll")
	public boolean  deleteAll() {
		 mservice.detAll();
		 return true;
	}
	
	@PostMapping("getMedicineWithCategory")
	public MedicineModel getMedicineWithCategory(@RequestBody DummyModel request) throws FileNotFoundInDatabase {
		MedicineModel m = new MedicineModel();
		if((request.getId() == null)) {
			throw new FileNotFoundInDatabase();
		}else {
			m = mservice.getMedicineWithCategory(request.getId());
		}
		return m; 
	}
	
}
