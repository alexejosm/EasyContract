package com.osmolovskyy.EasyContracts.dummy.dto.converter;

import com.osmolovskyy.EasyContracts.dummy.bo.PersonBo;
import com.osmolovskyy.EasyContracts.dummy.dto.PersonDto;
import com.osmolovskyy.EasyContracts.dummy.dto.PersonRequestDto;

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
