package es.dbiosag.command.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.dbiosag.command.application.dto.CreatePhoneRequest;
import es.dbiosag.command.domain.converter.PhoneConverter;
import es.dbiosag.command.infrasturcture.eventsourcing.KafkaPhoneCreatedEventSourcing;
import es.dbiosag.command.infrasturcture.eventsourcing.events.PhoneCreatedEvent;
import es.dbiosag.command.infrasturcture.repository.PhoneRepository;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
public class CreateUserService {

    @Autowired
    private PhoneConverter phoneConverter;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private KafkaPhoneCreatedEventSourcing kafkaPhoneCreatedEventSourcing;

    @Transactional
    public PhoneCreatedEvent create(CreatePhoneRequest request) {
        log.info("Creating new phone");
        val phone = phoneConverter.createPhoneRequestRequestToPhone(request);
        phoneRepository.save(phone);
        try {
            return kafkaPhoneCreatedEventSourcing.publicCreatePhoneEvent(phone);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
