package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.entity.CategoryEntity;

public interface CategoryEntityRepository extends MongoRepository<CategoryEntity, String>{

}
