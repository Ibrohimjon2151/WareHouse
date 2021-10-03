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
public class InputProduct extends AbcNameEntity {
    private int amount;
    private double price;
    private Date exprireDate;

    @ManyToOne
    private Input input;

}
