package com.osmolovskyy.EasyContracts.person.persistence.entity;

import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PersonEntityUtil {

    public static PersonBo convertToPersonBo(final PersonEntity entity) {
        return PersonBo.builder()
                .id(entity.getPersonId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }

    public static void mapToPersonEntity(final PersonBo bo, final PersonEntity entity) {
        entity.setFirstName(bo.getFirstName());
        entity.setLastName(bo.getLastName());
        entity.setPersonId(bo.getId());
    }

}