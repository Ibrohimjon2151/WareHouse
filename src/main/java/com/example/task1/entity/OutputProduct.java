package com.example.task1.entity;

import com.example.task1.entity.template.AbcNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class OutputProduct extends AbcNameEntity {
   private int amount;
   private double price;
   @OneToOne
   private Product product;

   @ManyToOne
   private Output output;
}
