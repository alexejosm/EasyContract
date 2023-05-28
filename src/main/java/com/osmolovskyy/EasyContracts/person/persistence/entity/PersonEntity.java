package com.osmolovskyy.EasyContracts.person.persistence.entity;

import com.osmolovskyy.EasyContracts.commons.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_FIRST_NAME;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_LAST_NAME;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.FIELD_PERSON_ID;
import static com.osmolovskyy.EasyContracts.commons.persistence.DatabaseConstants.TABLE_PERSON;

@Entity
@Getter
@Setter
@Table(name = TABLE_PERSON)
public class PersonEntity extends BaseEntity {

    @Column(name = FIELD_PERSON_ID)
    private Long personId;

    @Column(name = FIELD_FIRST_NAME)
    private String firstName;

    @Column(name = FIELD_LAST_NAME)
    private String lastName;
}