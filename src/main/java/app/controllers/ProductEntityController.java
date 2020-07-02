package app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse;

import app.entity.ProductEntity;
import app.exception.DataNotFoundInDatabaseException;
import app.model.DummyModel;
import app.model.MedicineModel;
import app.repository.ProductEntityRepository;
import app.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductEntityController {
	
	@Autowired private ProductService pservice;
	@Autowired private ProductEntityRepository prrepo;
	
	@PostMapping("add")
	public ProductEntity addProduct(@RequestBody Optional<ProductEntity> p) {
		ProductEntity presult = new ProductEntity();
		if(p.isPresent()) {
			presult = pservice.addProduct(p.get());
		}else {
			ServerResponse.status(HttpStatus.NOT_FOUND);
		}
		return presult;	
	}
	
	@GetMapping("getall")
	public List <ProductEntity> getAllProducts(){
		return pservice.getAll();
	}
	
	@GetMapping("deleteProductbyId/{id}")
	public boolean getProductbyId(@PathVariable String id) throws DataNotFoundInDatabaseException {
		var result = false;
		if(!id.equals(null)) {
		  if(pservice.deleteProductbyId(id)) {
			  result = true;
		  }else {
			  result = false;
		  }  
		}else {
			throw new DataNotFoundInDatabaseException();
		}
		return result;
			
	}
	
	@PostMapping("getProductsByCategoryId")
	public List<ProductEntity> getProductsByCategoryId(@RequestBody DummyModel request) throws DataNotFoundInDatabaseException{
		List<ProductEntity> p = new ArrayList<ProductEntity>();
		System.out.println("coming here "+request);
		if(request.getId() == null) {
			throw new DataNotFoundInDatabaseException();
		}else {
			p = this.prrepo.getBycategoryid(request.getId()).get();
		}
		return p;
	}
	

}
