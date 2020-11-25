package es.dbiosag.command.infrasturcture.repository;

import es.dbiosag.command.domain.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {
}
