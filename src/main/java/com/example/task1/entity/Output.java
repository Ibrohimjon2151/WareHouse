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
public class Output extends AbcNameEntity {

    private Date date;
    private String factureNummber;
    private Integer code;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Currency currency;


    @ManyToOne
    private WareHouse wareHouse;

}
