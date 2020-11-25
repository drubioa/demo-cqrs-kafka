package es.dbiosag.query.application.controller;

import es.dbiosag.query.application.dto.PhoneResponse;
import es.dbiosag.query.application.exception.FindPhoneException;
import es.dbiosag.query.domain.exception.PhoneNotFoundException;
import es.dbiosag.query.domain.service.FindPhoneService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserQueryController {

    @Autowired
    private FindPhoneService findPhoneService;

    @GetMapping("phone/{name}")
    @ResponseStatus(HttpStatus.OK)
    public PhoneResponse findPhone(@PathVariable String name) {

        try{
            return findPhoneService.findByName(name);
        }catch (PhoneNotFoundException ex) {
            log.error(ex);
            throw new FindPhoneException();
        }
    }
}
