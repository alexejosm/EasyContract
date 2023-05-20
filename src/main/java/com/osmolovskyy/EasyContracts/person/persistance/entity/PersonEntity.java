package com.osmolovskyy.EasyContracts.person.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    private long personId;

    @Column(name = FIELD_FIRST_NAME)
    private String firstName;

    @Column(name = FIELD_LAST_NAME)
    private String lastName;

}
