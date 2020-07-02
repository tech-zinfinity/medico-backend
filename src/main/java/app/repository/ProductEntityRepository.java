package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.entity.ProductEntity;

public interface ProductEntityRepository extends MongoRepository<ProductEntity, String> {

	@Query("{'category_id': ?0}")
	public Optional<List<ProductEntity>> getBycategoryid(String category_id);
}
