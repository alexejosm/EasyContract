package com.osmolovskyy.EasyContracts.person.dto.converter;

import com.osmolovskyy.EasyContracts.person.bo.PersonBo;
import com.osmolovskyy.EasyContracts.person.dto.PersonDto;
import com.osmolovskyy.EasyContracts.person.dto.PersonRequestDto;

public class PersonDtoConverter {

    public static PersonDto toPersonDto(PersonBo bo) {
        return PersonDto.builder()
                .id(bo.getId())
                .firstName(bo.getFirstName())
                .lastName(bo.getLastName())
                .build();

    }

    public static PersonBo toPersonBo(PersonRequestDto request) {
        return PersonBo.builder()
                .id(request.getPersonId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
}
