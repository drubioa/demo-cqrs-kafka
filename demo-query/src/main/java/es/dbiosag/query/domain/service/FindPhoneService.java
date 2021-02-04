package es.dbiosag.query.domain.service;

import es.dbiosag.query.application.dto.PhoneResponse;
import es.dbiosag.query.domain.converter.PhoneConverter;
import es.dbiosag.query.domain.exception.PhoneNotFoundException;
import es.dbiosag.query.domain.model.Phone;
import es.dbiosag.query.infrastructure.repository.PhoneRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FindPhoneService {

    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private PhoneConverter phoneConverter;

    public PhoneResponse findByName(String name) throws PhoneNotFoundException {
        Phone phone = phoneRepository.findByName(name).orElseThrow(() -> new PhoneNotFoundException(name, "Phone not found"));
        log.info("Find phone: {}", phone);
        return phoneConverter.phoneToPhoneResponse(phone);
    }

    public void createPhone(Phone p) {
        log.info("Insert new phone: {}", p);
        phoneRepository.save(p);
    }
}
