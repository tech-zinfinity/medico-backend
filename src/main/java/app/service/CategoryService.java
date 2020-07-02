package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.CategoryEntity;
import app.entity.ProductEntity;
import app.repository.CategoryEntityRepository;
import app.repository.ProductEntityRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryEntityRepository crepo;
	@Autowired
	private ProductEntityRepository prrepo;

	public CategoryEntity addCategory(CategoryEntity c) {
		CategoryEntity result = crepo.insert(c);
		return result;
	}

	public List<CategoryEntity> getAll() {
		return crepo.findAll();
	}

	public CategoryEntity getCategoryStatus(String id, boolean status) {
		CategoryEntity c = crepo.findById(id).get();
		c.setActive(status);
		return crepo.save(c);
	}

	public String updateStatusOfProductWithCategory(String category_id, boolean status, List<String> prList) {
		String catid = "";
		if (prList.isEmpty()) {
			var c = crepo.findById(category_id);
			if (c.isPresent()) {
				CategoryEntity ca = c.get();
				ca.setActive(status);
				crepo.save(ca);

				prrepo.getBycategoryid(category_id).get().forEach(product -> {
					product.setActive(status);
					prrepo.save(product);
				});
				catid.concat(category_id);
			}
		} else {
			var c = crepo.findById(category_id);
			if (c.isPresent()) {
				CategoryEntity ca = c.get();
				ca.setActive(status);
				crepo.save(ca);

				prList.forEach(id -> {
					var p = prrepo.findById(id).get();
					p.setActive(status);
					prrepo.save(p);
				});
				catid.concat(category_id);
			}
		}
		return catid;
	}
}
