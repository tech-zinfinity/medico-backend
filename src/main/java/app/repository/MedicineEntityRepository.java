package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.entity.MedicineEntity;

public interface MedicineEntityRepository extends MongoRepository<MedicineEntity, String>{

}
