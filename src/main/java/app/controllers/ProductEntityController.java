package app.controllers;

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
	public boolean getProductbyId(@PathVariable String id) {
		var result = false;
		if(!id.equals(null)) {
		  if(pservice.deleteProductbyId(id)) {
			  result = true;
		  }else {
			  result = false;
		  }  
		}else {
			ServerResponse.notFound();
			return false;
		}
		return result;
			
	}
	
	@GetMapping("getProductsByCategoryId/{id}")
	public List<ProductEntity> getProductsByCategoryId(@PathVariable String id){
		return this.prrepo.getBycategoryid(id).get();
	}
	

}
