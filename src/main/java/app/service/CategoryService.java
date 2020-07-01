package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.CategoryEntity;
import app.repository.CategoryEntityRepository;

@Service
public class CategoryService {

	@Autowired private CategoryEntityRepository crepo;
	
	public CategoryEntity addCategory(CategoryEntity c) {
		
		CategoryEntity result = crepo.insert(c);
		
		return result;
		
	}
	
	public List<CategoryEntity> getAll(){
		return crepo.findAll();
	}
	
    
}
