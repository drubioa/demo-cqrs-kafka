package es.dbiosag.command.application.controller;

import es.dbiosag.command.application.dto.CreatePhoneRequest;
import es.dbiosag.command.domain.service.CreateUserService;
import es.dbiosag.command.infrasturcture.eventsourcing.events.PhoneCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCommandController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping("phone")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PhoneCreatedEvent newPhone(@RequestBody  CreatePhoneRequest req) {
        return createUserService.create(req);
    }

}
