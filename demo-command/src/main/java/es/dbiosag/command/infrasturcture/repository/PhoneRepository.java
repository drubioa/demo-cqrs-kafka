package es.dbiosag.command.infrasturcture.repository;

import es.dbiosag.command.domain.model.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, Integer> {
}
