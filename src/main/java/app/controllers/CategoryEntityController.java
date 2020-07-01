package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse;

import app.entity.CategoryEntity;
import app.entity.MedicineEntity;
import app.model.UpdateCategoryStatusWithProductsRequest;
import app.service.CategoryService;

@RestController
@RequestMapping("cat")
public class CategoryEntityController {
	
	@Autowired CategoryService cService;
	@PostMapping("add")
	public CategoryEntity addCategory(@RequestBody Optional<CategoryEntity> c) {
		CategoryEntity result = new CategoryEntity();
		if(c.isPresent()) {
			result = cService.addCategory(c.get());
		}else {
			ServerResponse.status(HttpStatus.NOT_FOUND);
		}
		return result;
	}
	
	@GetMapping("getAll")
	public List<CategoryEntity> getAllCategory() {
		return cService.getAll();
	}
	
	@PostMapping("updateStatusOfCategoryWithProduct")
	public String updateStatusOfCategoryWithProduct(@RequestBody UpdateCategoryStatusWithProductsRequest request) {
		return cService.updateStatusOfProductWithCategory(request.getCategory_id(), request.isStatus(), request.getPrList());
	}
}
