package es.dbiosag.query.infrastructure.repository;

import es.dbiosag.query.domain.model.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PhoneRepository extends MongoRepository<Phone, Integer> {

    Optional<Phone> findByName(String name);
}
