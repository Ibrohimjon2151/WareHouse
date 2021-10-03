package com.example.task1.entity;

import com.example.task1.entity.template.AbcNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Input extends AbcNameEntity {
    private Date date;
    private String FactureNummber;
    private String code;

    @ManyToOne
    WareHouse wareHouse;

    @ManyToOne
    Currency currency;

    @ManyToOne
    Suppiller suppiller;


}
