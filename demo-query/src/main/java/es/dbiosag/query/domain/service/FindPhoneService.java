package es.dbiosag.query.domain.service;

import es.dbiosag.query.application.dto.PhoneResponse;
import es.dbiosag.query.domain.converter.PhoneConverter;
import es.dbiosag.query.domain.exception.PhoneNotFoundException;
import es.dbiosag.query.domain.model.Phone;
import es.dbiosag.query.infrastructure.repository.PhoneRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class FindPhoneService {

    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private PhoneConverter phoneConverter;

    public PhoneResponse findByName(String name) throws PhoneNotFoundException {
        Optional<Phone> phone = phoneRepository.findByName(name);
        if(phone.isPresent()) {
            throw new PhoneNotFoundException(name, "Phone not found");
        }
        log.info("Find phone: {}", phone);
        return phoneConverter.phoneToPhoneResponse(phone.get());
    }

    public void createPhone(Phone p) {
        log.info("Insert new phone: {}", p);
        phoneRepository.save(p);
    }
}
