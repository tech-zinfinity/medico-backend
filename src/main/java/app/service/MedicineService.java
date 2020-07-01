package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.CategoryEntity;
import app.entity.MedicineEntity;
import app.model.MedicineModel;
import app.repository.CategoryEntityRepository;
import app.repository.MedicineEntityRepository;

@Service
public class MedicineService {

	@Autowired MedicineEntityRepository mrepo;
	@Autowired CategoryEntityRepository crepo;
	
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
	
	public void detAll(){
	  mrepo.deleteAll();	
	}

	public MedicineModel getMedicineWithCategory(String id) {
		
		MedicineEntity m = mrepo.findById(id).get();
		
		CategoryEntity c = crepo.findById(m.getCategory_entity_id()).get();
		
		return MedicineModel.builder().id(m.getId()).type(m.getType()).prescription_needed(m.isPrescription_needed())
				.name(m.getName()).description(m.getDescription()).barcode_no(m.getBarcode_no()).category_entity(c).build();
	}
	
	
}
