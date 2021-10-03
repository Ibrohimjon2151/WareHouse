package com.example.task1.entity;

import com.example.task1.entity.template.AbcNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Users extends AbcNameEntity {
    private String lastName;
    private String phoneNummber;
    private String password;
    private String code;

}
