package com.osmolovskyy.EasyContracts.person.dto;

import com.osmolovskyy.EasyContracts.commons.dto.BaseDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PersonRequestDto implements BaseDto {

    @NotEmpty
    @Size(min = 4)
    private String personId;

    @NotEmpty
    @Size(max = 40)
    private String firstName;

    @NotEmpty
    @Size(max = 40)
    private String lastName;
}