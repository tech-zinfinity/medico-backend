package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.MedicineEntity;
import app.repository.MedicineEntityRepository;

@Service
public class MedicineService {

	@Autowired MedicineEntityRepository mrepo;
	
	public void getMedicine() {
		MedicineEntity m = new MedicineEntity();
		
		m.setId("medicine-1");
		m.setName("SariDon");
		m.setPrescription_needed(true);
		m.setDescription("something");
		m.setType("tablet");
		
		System.out.println(m.toString());
		
		MedicineEntity m2 = new MedicineEntity();
		
		m2.setId("medicine-2");
		m2.setName("Sarimon");
		m2.setPrescription_needed(false);
		m2.setDescription("else");
		m2.setType("syrup");
		
		System.out.println(m2.getName());
	}
	
	public MedicineEntity addMedicine(MedicineEntity m) {
		if(m.isPrescription_needed() == true) {
			m.setBarcode_no(m.getBarcode_no()+"-prescribe");
		}
		return mrepo.insert(m);
	}
	
	public List<MedicineEntity> getAll() {
		return mrepo.findAll();
	}
	
	public Optional<MedicineEntity> getById(String id) {
		return mrepo.findById(id);
	}
}
