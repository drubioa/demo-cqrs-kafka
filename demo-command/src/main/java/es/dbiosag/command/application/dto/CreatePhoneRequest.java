package es.dbiosag.command.application.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreatePhoneRequest {

    private String name;
    private String model;
    private String color;
    private Double price;
}
