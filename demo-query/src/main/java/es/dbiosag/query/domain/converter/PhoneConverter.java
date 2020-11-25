package es.dbiosag.query.domain.converter;

import es.dbiosag.query.application.dto.PhoneResponse;
import es.dbiosag.query.domain.model.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneConverter {

    public PhoneResponse phoneToPhoneResponse(Phone p) {
        return PhoneResponse.builder().color(p.getColor())
                .model(p.getModel())
                .name(p.getName())
                .price(p.getPrice())
                .build();
    }
}
