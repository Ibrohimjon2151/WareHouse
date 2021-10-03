package com.example.task1.entity;

import com.example.task1.entity.template.AbcNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class WareHouse extends AbcNameEntity {

    @ManyToMany
    List<Users> users;

}
