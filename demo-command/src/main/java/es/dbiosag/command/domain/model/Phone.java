package es.dbiosag.command.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "PHONES")
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID_PHONE")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "COLOR")
    private String color;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "CREATION_DATE")
    private String creationDate;
}
