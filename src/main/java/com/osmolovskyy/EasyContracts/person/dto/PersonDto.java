package com.osmolovskyy.EasyContracts.person.dto;

import com.osmolovskyy.EasyContracts.commons.dto.BaseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto implements BaseDto {

    private String id;
    private String firstName;
    private String lastName;
}