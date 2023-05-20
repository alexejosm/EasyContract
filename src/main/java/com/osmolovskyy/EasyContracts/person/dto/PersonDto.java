package com.osmolovskyy.EasyContracts.person.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto implements BaseDto {

    private long id;
    private String firstName;
    private String lastName;
}
