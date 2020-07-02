package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.ProductEntity;
import app.repository.ProductEntityRepository;

@Service
public class ProductService {
	
	@Autowired 
	ProductEntityRepository prepo;
	
	public ProductEntity addProduct(ProductEntity p) {
		
		return  prepo.insert(p);
				
	}
	
	public boolean deleteProductbyId(String id) {
		boolean result = false;
		try {
			prepo.deleteById(id);
			result = true;
		}catch (Exception e) {
			e.printStackTrace();
			result = false;
			// TODO: handle exception
		}
		return result;
	}
	
	public List<ProductEntity> getAll() {
		return prepo.findAll();
	}
	
	
	public ProductEntity getProductStatus(String id,boolean status) {
		ProductEntity p = prepo.findById(id).get();
		p.setActive(status);
		return prepo.save(p);
	}
	
	

}
