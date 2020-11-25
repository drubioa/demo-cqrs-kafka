package es.dbiosag.query.infrastructure.repository;

import es.dbiosag.query.domain.model.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    Optional<Phone> findByName(String name);
}
