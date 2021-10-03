package com.example.task1.entity;

import com.example.task1.entity.template.AbcNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentContent extends AbcNameEntity {
    public byte [] bytes;

    @OneToOne
    Attachment attechmant;
}
